package segmentify.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

    public static long getTime(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime).getTime();
    }

    public static LocalDateTime toLocalDateTime(long time) {
        return new Timestamp(time).toLocalDateTime();
    }
}
