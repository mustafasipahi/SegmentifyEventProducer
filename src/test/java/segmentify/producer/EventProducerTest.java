package segmentify.producer;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import segmentify.configuration.proporties.KafkaProperties;
import segmentify.request.PageViewEventRequest;
import segmentify.request.ProductViewEventRequest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventProducerTest {

    @InjectMocks
    private EventProducer eventProducer;
    @Mock
    private KafkaTemplate<Object, Object> kafkaTemplate;
    @Mock
    private KafkaProperties kafkaProperties;

    @Test
    void shouldSendProductViewEvent() {
        final ProductViewEventRequest request = ProductViewEventRequest.builder()
                .apiKey(RandomStringUtils.randomNumeric(3))
                .build();
        final KafkaProperties.Topic topic = new KafkaProperties.Topic();
        topic.setProductView(RandomStringUtils.randomNumeric(3));
        when(kafkaProperties.getTopic()).thenReturn(topic);
        eventProducer.sendProductViewEvent(request);
        verify(kafkaTemplate).send(topic.getProductView(), request);
    }

    @Test
    void shouldSendPageViewEvent() {
        final PageViewEventRequest request = PageViewEventRequest.builder()
                .apiKey(RandomStringUtils.randomNumeric(3))
                .build();
        final KafkaProperties.Topic topic = new KafkaProperties.Topic();
        topic.setPageView(RandomStringUtils.randomNumeric(3));
        when(kafkaProperties.getTopic()).thenReturn(topic);
        eventProducer.sendPageViewEvent(request);
        verify(kafkaTemplate).send(topic.getPageView(), request);
    }
}