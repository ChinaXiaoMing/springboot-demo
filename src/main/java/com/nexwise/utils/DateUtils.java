package com.nexwise.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间处理类
 */
public class DateUtils {

    /**
     * 格式化当前时间
     * @return
     */
    public static String getLocalDate() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }

}
