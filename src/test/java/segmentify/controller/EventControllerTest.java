package segmentify.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import segmentify.service.EventService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EventControllerTest {

    @InjectMocks
    private EventController eventController;
    @Mock
    private EventService eventService;

    @Test
    void shouldAcceptEvent() {
        final Set<Object> eventSet = new HashSet<>();
        final String apiKey = RandomStringUtils.randomNumeric(3);
        eventController.acceptEvent(eventSet, apiKey);
        verify(eventService).acceptEvent(eventSet, apiKey);
    }
}