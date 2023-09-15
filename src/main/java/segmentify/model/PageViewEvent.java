package segmentify.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageViewEvent extends Event {

    private String category;
    private String subCategory;
}
