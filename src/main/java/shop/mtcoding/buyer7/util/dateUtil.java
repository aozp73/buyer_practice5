package shop.mtcoding.buyer7.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateUtil {

    public static String format(Timestamp stamp) {
        LocalDateTime formatTime = stamp.toLocalDateTime();
        String res = formatTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return res;
    }
}
