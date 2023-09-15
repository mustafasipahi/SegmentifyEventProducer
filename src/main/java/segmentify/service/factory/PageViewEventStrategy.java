package segmentify.service.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import segmentify.constants.EventNameType;
import segmentify.model.PageViewEvent;
import segmentify.producer.EventProducer;
import segmentify.request.PageViewEventRequest;

import java.util.Objects;

import static segmentify.mapper.MyObjectMapper.convertToPageView;

@Service
@RequiredArgsConstructor
public class PageViewEventStrategy implements EventStrategy {

    private final EventProducer eventProducer;

    @Override
    public void execute(Object event, String apiKey) {
        final PageViewEvent pageViewEvent = convertToPageView(event);
        final PageViewEventRequest pageViewEventRequest = PageViewEventRequest.builder()
                .pageViewEvent(pageViewEvent)
                .apiKey(apiKey)
                .build();
        eventProducer.sendPageViewEvent(pageViewEventRequest);
    }

    @Override
    public boolean isExecutable(EventNameType name) {
        return Objects.equals(name, EventNameType.PAGE_VIEW);
    }
}
