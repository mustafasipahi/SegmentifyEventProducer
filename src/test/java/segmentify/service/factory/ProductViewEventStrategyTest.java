package segmentify.service.factory;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import segmentify.constants.EventNameType;
import segmentify.model.ProductViewEvent;
import segmentify.producer.EventProducer;
import segmentify.request.ProductViewEventRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductViewEventStrategyTest {

    @InjectMocks
    private ProductViewEventStrategy productViewEventStrategy;
    @Mock
    private EventProducer eventProducer;

    @Test
    void shouldIsExecutable() {
        assertTrue(productViewEventStrategy.isExecutable(EventNameType.PRODUCT_VIEW));
    }

    @Test
    void shouldExecute() {
        final ProductViewEvent productViewEvent = new ProductViewEvent();
        productViewEvent.setCategory(RandomStringUtils.randomNumeric(3));
        final String apiKey = RandomStringUtils.randomNumeric(3);
        productViewEventStrategy.execute(productViewEvent, apiKey);

        ArgumentCaptor<ProductViewEventRequest> captor = ArgumentCaptor.forClass(ProductViewEventRequest.class);
        verify(eventProducer).sendProductViewEvent(captor.capture());
        final ProductViewEventRequest captorValue = captor.getValue();

        assertEquals(apiKey, captorValue.getApiKey());
        assertEquals(productViewEvent.getCategory(), captorValue.getProductViewEvent().getCategory());
    }
}