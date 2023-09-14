package segmentify.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import segmentify.advice.exception.MyRuntimeException;
import segmentify.advice.exception.MyValidationException;
import segmentify.response.EventResponse;
import segmentify.constants.EventResponseType;

@Slf4j
@ControllerAdvice
public class MyAdvice {

    @ExceptionHandler(MyRuntimeException.class)
    public ResponseEntity<EventResponse> handleException(MyRuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new EventResponse(e.getEventResponseType()));
    }

    @ExceptionHandler(MyValidationException.class)
    public ResponseEntity<EventResponse> handleException(MyValidationException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new EventResponse(e.getEventResponseType()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<EventResponse> handleException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new EventResponse(EventResponseType.BAD_INPUT));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EventResponse> handleException(Exception e) {
        log.error("An unknown exception", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new EventResponse(EventResponseType.UNKNOWN));
    }
}