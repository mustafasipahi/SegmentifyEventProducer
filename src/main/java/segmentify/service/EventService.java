package segmentify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import segmentify.constants.EventResponseType;
import segmentify.dto.EventDto;
import segmentify.producer.EventProducer;
import segmentify.request.EventRequest;
import segmentify.response.EventResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventProducer eventProducer;

    @Transactional
    public EventResponse acceptEvent(List<EventDto> eventList, String apiKey) {
        eventProducer.sendEvent(createEventRequest(eventList, apiKey));
        return new EventResponse(EventResponseType.SUCCESS);
    }

    private EventRequest createEventRequest(List<EventDto> eventList, String apiKey) {
        return EventRequest.builder()
                .eventList(eventList)
                .apiKey(apiKey)
                .build();
    }
}
