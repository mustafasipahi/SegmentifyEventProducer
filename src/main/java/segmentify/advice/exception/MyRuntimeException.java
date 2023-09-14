package segmentify.advice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import segmentify.constants.EventResponseType;

@Getter
@AllArgsConstructor
public class MyRuntimeException extends RuntimeException {

    private final EventResponseType eventResponseType;
}
