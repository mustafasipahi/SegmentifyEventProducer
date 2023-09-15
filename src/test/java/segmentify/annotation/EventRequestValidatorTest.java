package segmentify.annotation;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import segmentify.advice.exception.MyValidationException;
import segmentify.constants.EventResponseType;

import java.util.HashSet;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EventRequestValidatorTest {

    @InjectMocks
    private EventRequestValidator eventRequestValidator;

    @Test
    void shouldThrowMyValidationExceptionWhenEventListEmpty() {
        HashSet<Object> eventSet = new HashSet<>();
        final MyValidationException exception = assertThrows(
                MyValidationException.class,
                () -> eventRequestValidator.isValid(eventSet, null)
        );
        assertEquals(EventResponseType.NO_EVENT, exception.getEventResponseType());
    }

    @Test
    void shouldThrowMyValidationExceptionWhenUserIdEmpty() {
        HashSet<Object> eventSet = new HashSet<>();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("sessionId", RandomStringUtils.randomNumeric(3));
        eventSet.add(map);
        final MyValidationException exception = assertThrows(
                MyValidationException.class,
                () -> eventRequestValidator.isValid(eventSet, null)
        );
        assertEquals(EventResponseType.NO_USERID, exception.getEventResponseType());
    }

    @Test
    void shouldThrowMyValidationExceptionWhenSessionIdEmpty() {
        HashSet<Object> eventSet = new HashSet<>();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("userId", RandomStringUtils.randomNumeric(3));
        eventSet.add(map);
        final MyValidationException exception = assertThrows(
                MyValidationException.class,
                () -> eventRequestValidator.isValid(eventSet, null)
        );
        assertEquals(EventResponseType.NO_SESSIONID, exception.getEventResponseType());
    }

    @Test
    void shouldReturnTrueIsValid() {
        HashSet<Object> eventSet = new HashSet<>();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("userId", RandomStringUtils.randomNumeric(3));
        map.put("sessionId", RandomStringUtils.randomNumeric(3));
        eventSet.add(map);
        assertTrue(eventRequestValidator.isValid(eventSet, null));
    }
}