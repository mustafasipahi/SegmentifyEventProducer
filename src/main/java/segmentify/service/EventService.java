package segmentify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import segmentify.constants.EventNameType;
import segmentify.constants.EventResponseType;
import segmentify.response.EventResponse;
import segmentify.service.factory.EventFactory;

import java.util.Set;

import static segmentify.utils.EventNameUtil.getEventNameType;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventFactory eventFactory;

    @Transactional
    public EventResponse acceptEvent(Set<Object> eventSet, String apiKey) {
        eventSet.forEach(event -> {
            final EventNameType eventNameType = getEventNameType(event);
            final EventFactory strategy = eventFactory.getStrategy(eventNameType);
            strategy.execute(event, apiKey);
        });
        return new EventResponse(EventResponseType.SUCCESS);
    }
}
