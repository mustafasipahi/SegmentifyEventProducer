package segmentify.service.factory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import segmentify.advice.exception.NoSuchEventException;
import segmentify.constants.EventNameType;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventFactory {

    private EventStrategy eventStrategy;
    private final List<EventStrategy> strategyList;

    public EventFactory getStrategy(EventNameType name) {
        eventStrategy = strategyList.stream()
                .filter(each -> each.isExecutable(name))
                .findAny()
                .orElseThrow(NoSuchEventException::new);
        return this;
    }

    public void execute(Object event, String apiKey) {
        eventStrategy.execute(event, apiKey);
    }
}
