package segmentify.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import segmentify.configuration.proporties.KafkaProperties;
import segmentify.request.EventRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<Object, Object> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    @Async
    public void sendEvent(EventRequest eventRequest) {
        kafkaTemplate.send(kafkaProperties.getTopic().getTest(), eventRequest);
        log.info("kafkaTemplate send to topic : {} request : {}", kafkaProperties.getTopic().getTest(), eventRequest.toString());
    }
}
