package segmentify.advice.exception;

import lombok.Getter;
import lombok.Setter;
import segmentify.constants.EventResponseType;

import javax.validation.ConstraintDeclarationException;

@Getter
@Setter
public class MyValidationException extends ConstraintDeclarationException {

    private EventResponseType eventResponseType;

    public MyValidationException(EventResponseType eventResponseType) {
        super();
        this.eventResponseType = eventResponseType;
    }
}
