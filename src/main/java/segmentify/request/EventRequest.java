package segmentify.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import segmentify.annotation.ValidateEventRequest;
import segmentify.dto.EventDto;

import java.util.List;

@Getter
@Setter
@ToString
@ValidateEventRequest
public class EventRequest {

    private List<EventDto> eventList;
}
