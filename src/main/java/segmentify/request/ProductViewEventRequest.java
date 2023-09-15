package segmentify.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import segmentify.model.ProductViewEvent;

@Getter
@Setter
@ToString
@Builder
public class ProductViewEventRequest {

    private ProductViewEvent productViewEvent;
    private String apiKey;
}
