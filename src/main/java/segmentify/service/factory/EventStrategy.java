package segmentify.service.factory;

import segmentify.constants.EventNameType;

public interface EventStrategy {

    void execute(Object event, String apiKey);
    boolean isExecutable(EventNameType name);
}
