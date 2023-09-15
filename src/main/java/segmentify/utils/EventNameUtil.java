package segmentify.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import segmentify.advice.exception.NoSuchEventException;
import segmentify.constants.EventNameType;

import java.util.LinkedHashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventNameUtil {

    public static EventNameType getEventNameType(Object event) {
        try {
            LinkedHashMap<String, String> eventMap = (LinkedHashMap) event;
            return EventNameType.valueOf(eventMap.get("name"));
        } catch (Exception e) {
            throw new NoSuchEventException();
        }
    }
}
