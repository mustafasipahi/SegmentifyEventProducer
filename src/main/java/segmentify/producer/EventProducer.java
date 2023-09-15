package segmentify.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import segmentify.configuration.proporties.KafkaProperties;
import segmentify.request.PageViewEventRequest;
import segmentify.request.ProductViewEventRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<Object, Object> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    @Async
    public void sendProductViewEvent(ProductViewEventRequest request) {
        kafkaTemplate.send(kafkaProperties.getTopic().getProductView(), request);
        log.info("kafkaTemplate sendProductViewEvent to topic : {} request : {}",
                kafkaProperties.getTopic().getProductView(),
                request.toString()
        );
    }

    @Async
    public void sendPageViewEvent(PageViewEventRequest request) {
        kafkaTemplate.send(kafkaProperties.getTopic().getPageView(), request);
        log.info("kafkaTemplate sendPageViewEvent to topic : {} request : {}",
                kafkaProperties.getTopic().getPageView(),
                request.toString()
        );
    }
}
