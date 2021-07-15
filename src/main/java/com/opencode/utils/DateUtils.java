package com.opencode.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * JDK1.8时间处理类
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
public class DateUtils {

    /**
     * 默认本地时间格式为 yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 格式化当地日期时间
     *
     * @return 格式化后的本地时间字符串
     */
    public static String getLocalDateTime() {
        return DATE_TIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 时间戳转本地时间格式
     *
     * @param epochMilli 毫秒时间戳
     * @return 本地时间格式
     */
    public static String getLocalDateTime(Long epochMilli) {
        return DATE_TIME_FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault()));
    }

    /**
     * 本地时间格式时间转时间戳
     *
     * @param time 本地时间格式时间
     * @return 毫秒时间戳
     */
    public static Long convertToEpochMilli(String time) {
        return LocalDateTime.from(LocalDateTime.parse(time, DATE_TIME_FORMATTER)).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

}
