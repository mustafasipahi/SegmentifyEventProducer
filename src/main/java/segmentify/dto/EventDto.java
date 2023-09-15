package segmentify.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import segmentify.constants.DeviceType;
import segmentify.constants.EventNameType;

import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EventDto implements Serializable {

    private EventNameType name;
    private String userId;
    private String sessionId;
    private String pageUrl;
    private String category;
    private DeviceType device;
}
