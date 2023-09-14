package segmentify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import segmentify.constants.EventResponseType;
import segmentify.producer.EventProducer;
import segmentify.request.EventRequest;
import segmentify.response.EventResponse;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventProducer eventProducer;

    @Transactional
    public EventResponse acceptEvent(EventRequest eventRequest) {
        eventProducer.sendEvent(eventRequest);
        return new EventResponse(EventResponseType.SUCCESS);
    }
}
