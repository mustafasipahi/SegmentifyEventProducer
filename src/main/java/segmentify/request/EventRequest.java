package segmentify.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import segmentify.dto.EventDto;

import java.util.List;

@Getter
@Setter
@Builder
public class EventRequest {

    private List<EventDto> eventList;
    private String apiKey;
}
