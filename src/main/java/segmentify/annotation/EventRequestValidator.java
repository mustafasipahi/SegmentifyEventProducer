package segmentify.annotation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import segmentify.advice.exception.MyValidationException;
import segmentify.constants.EventResponseType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.LinkedHashMap;
import java.util.Set;

public class EventRequestValidator implements ConstraintValidator<ValidateEventRequest, Set<Object>> {

    @Override
    public boolean isValid(Set<Object> eventSet, ConstraintValidatorContext context) {
        if (CollectionUtils.isEmpty(eventSet)) {
            throw new MyValidationException(EventResponseType.NO_EVENT);
        }
        eventSet.forEach(event -> {
            LinkedHashMap<String, String> eventMap = (LinkedHashMap) event;
            if (StringUtils.isBlank(eventMap.get("userId"))) {
                throw new MyValidationException(EventResponseType.NO_USERID);
            }
            if (StringUtils.isBlank(eventMap.get("sessionId"))) {
                throw new MyValidationException(EventResponseType.NO_SESSIONID);
            }
        });
        return true;
    }
}
