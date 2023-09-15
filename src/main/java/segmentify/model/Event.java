package segmentify.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import segmentify.constants.*;

import java.util.HashMap;

@Getter
@Setter
@ToString
public abstract class Event {

    private EventNameType name;
    private String userId;
    private String sessionId;
    private DeviceType device;
    private String userAgent;
    private Language lang;
    private String region;
    private String currency;
    private BrowserType browser;
    private OperatingSystemType os;
    private String osversion;
    private String pageUrl;
    private String referrer;
    private HashMap<String, String> params;
    private boolean testMode;
    private boolean nextPage;
}
