package segmentify.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import segmentify.constants.EventResponseType;
import segmentify.utils.DateUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EventResponse {

    private final long timestamp;
    private final EventResponseType statusCode;

    public EventResponse(EventResponseType statusCode) {
        this.timestamp = DateUtils.getTime(LocalDateTime.now());
        this.statusCode = statusCode;
    }
}
