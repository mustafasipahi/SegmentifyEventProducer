package segmentify.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import segmentify.service.factory.EventFactory;
import segmentify.service.factory.PageViewEventStrategy;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static segmentify.constants.EventNameType.PAGE_VIEW;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @InjectMocks
    private EventService eventService;
    @Mock
    private EventFactory eventFactory;
    @Mock
    private PageViewEventStrategy pageViewEventStrategy;

    @Test
    void shouldAcceptEvent() {
        HashSet<Object> eventSet = new HashSet<>();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", PAGE_VIEW.name());
        eventSet.add(map);
        final String apiKey = RandomStringUtils.randomNumeric(3);

        EventFactory eventFactoryNew = new EventFactory(Collections.singletonList(pageViewEventStrategy));
        eventFactoryNew.setEventStrategy(pageViewEventStrategy);

        when(eventFactory.getStrategy(PAGE_VIEW)).thenReturn(eventFactoryNew);
        eventService.acceptEvent(eventSet, apiKey);
        verify(pageViewEventStrategy).execute(eventSet.iterator().next(), apiKey);
    }
}