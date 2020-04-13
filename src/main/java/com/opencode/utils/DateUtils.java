package com.opencode.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * JDK1.8时间处理类
 */
public class DateUtils {

    //默认本地时间格式为 yyyy-MM-dd HH:mm:ss
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 格式化当前时间
     * @return
     */
    public static String getLocalDateTime() {
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    /**
     * 时间戳转本地时间格式
     * @param epochMilli 毫秒时间戳
     * @return 本地时间格式
     */
    public static String getLocalDateTime(Long epochMilli) {
        return dateTimeFormatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault()));
    }

    /**
     * 本地时间格式时间转时间戳
     * @param time 本地时间格式时间
     * @return 毫秒时间戳
     */
    public static Long convertToEpochMilli(String time) {
        return LocalDateTime.from(LocalDateTime.parse(time, dateTimeFormatter)).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

}
