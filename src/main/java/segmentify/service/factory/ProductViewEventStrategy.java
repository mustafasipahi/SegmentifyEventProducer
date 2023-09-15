package segmentify.service.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import segmentify.constants.EventNameType;
import segmentify.model.ProductViewEvent;
import segmentify.producer.EventProducer;
import segmentify.request.ProductViewEventRequest;

import java.util.Objects;

import static segmentify.mapper.MyObjectMapper.convertToProductView;

@Service
@RequiredArgsConstructor
public class ProductViewEventStrategy implements EventStrategy {

    private final EventProducer eventProducer;

    @Override
    public void execute(Object event, String apiKey) {
        final ProductViewEvent productViewEvent = convertToProductView(event);
        final ProductViewEventRequest productViewEventRequest = ProductViewEventRequest.builder()
                .productViewEvent(productViewEvent)
                .apiKey(apiKey)
                .build();
        eventProducer.sendProductViewEvent(productViewEventRequest);
    }

    @Override
    public boolean isExecutable(EventNameType name) {
        return Objects.equals(name, EventNameType.PRODUCT_VIEW);
    }
}
