package segmentify.service.factory;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import segmentify.constants.EventNameType;
import segmentify.model.PageViewEvent;
import segmentify.producer.EventProducer;
import segmentify.request.PageViewEventRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PageViewEventStrategyTest {

    @InjectMocks
    private PageViewEventStrategy pageViewEventStrategy;
    @Mock
    private EventProducer eventProducer;

    @Test
    void shouldIsExecutable() {
        assertTrue(pageViewEventStrategy.isExecutable(EventNameType.PAGE_VIEW));
    }

    @Test
    void shouldExecute() {
        final PageViewEvent pageViewEvent = new PageViewEvent();
        pageViewEvent.setCategory(RandomStringUtils.randomNumeric(3));
        final String apiKey = RandomStringUtils.randomNumeric(3);
        pageViewEventStrategy.execute(pageViewEvent, apiKey);

        ArgumentCaptor<PageViewEventRequest> captor = ArgumentCaptor.forClass(PageViewEventRequest.class);
        verify(eventProducer).sendPageViewEvent(captor.capture());
        final PageViewEventRequest captorValue = captor.getValue();

        assertEquals(apiKey, captorValue.getApiKey());
        assertEquals(pageViewEvent.getCategory(), captorValue.getPageViewEvent().getCategory());
    }
}