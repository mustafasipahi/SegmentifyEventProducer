package segmentify.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import segmentify.constants.EventNameType;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EventDto {

    private EventNameType name;
    private String userId;
    private String sessionId;
    private String pageUrl;
    private String category;
    private String device;
}
