package segmentify.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import segmentify.advice.exception.NoSuchEventException;
import segmentify.model.PageViewEvent;
import segmentify.model.ProductViewEvent;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MyObjectMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ProductViewEvent convertToProductView(Object event) {
        try {
            return objectMapper.convertValue(event, ProductViewEvent.class);
        } catch (IllegalArgumentException e) {
            throw new NoSuchEventException();
        }
    }

    public static PageViewEvent convertToPageView(Object event) {
        try {
            return objectMapper.convertValue(event, PageViewEvent.class);
        } catch (IllegalArgumentException e) {
            throw new NoSuchEventException();
        }
    }
}
