package segmentify.advice.exception;

import segmentify.constants.EventResponseType;

public class NoSuchEventException extends  MyRuntimeException {

    public NoSuchEventException() {
        super(EventResponseType.NO_EVENT);
    }
}
