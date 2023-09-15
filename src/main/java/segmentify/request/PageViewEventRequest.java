package segmentify.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import segmentify.model.PageViewEvent;

@Getter
@Setter
@ToString
@Builder
public class PageViewEventRequest {

    private PageViewEvent pageViewEvent;
    private String apiKey;
}
