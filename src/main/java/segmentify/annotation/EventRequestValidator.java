package segmentify.annotation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import segmentify.advice.exception.MyValidationException;
import segmentify.constants.EventResponseType;
import segmentify.dto.EventDto;
import segmentify.request.EventRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EventRequestValidator implements ConstraintValidator<ValidateEventRequest, EventRequest> {

    @Override
    public boolean isValid(EventRequest request, ConstraintValidatorContext context) {
        List<EventDto> eventList = request.getEventList();
        if (CollectionUtils.isEmpty(eventList)) {
            throw new MyValidationException(EventResponseType.NO_EVENT);
        }
        eventList.forEach(event -> {
            if (StringUtils.isBlank(event.getUserId())) {
                throw new MyValidationException(EventResponseType.NO_USERID);
            }
            if (StringUtils.isBlank(event.getSessionId())) {
                throw new MyValidationException(EventResponseType.NO_SESSIONID);
            }
        });
        return true;
    }
}