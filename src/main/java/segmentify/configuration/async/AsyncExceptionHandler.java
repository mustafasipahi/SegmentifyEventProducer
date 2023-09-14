package segmentify.configuration.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Component
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        log.info("Exception message : {}", throwable.getMessage());
        log.info("Method name : {}", method.getName());
        for (Object param : objects) {
            log.info("Parameter value : {}", param);
        }
    }
}
