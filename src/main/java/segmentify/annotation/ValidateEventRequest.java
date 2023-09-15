package segmentify.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EventRequestValidator.class)
public @interface ValidateEventRequest {

    String message() default "Unknown Value!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
