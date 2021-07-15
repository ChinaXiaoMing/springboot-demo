package com.opencode.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * json序列化与反序列化工具类
 *
 * @author fu.yuanming
 * @since 2020/6/6 11:24
 **/
@Slf4j
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtils() {}

    /**
     * json序列化
     *
     * @param object Java对象
     * @param <T> Java数据类型
     * @return json字符串
     */
    public static <T> String serialize(T object) {
        String value = null;
        try {
            value = OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("json序列化失败！error: {}", e.getMessage());
        }
        return value;
    }

    /**
     * json反序列化
     *
     * @param value json字符串
     * @param clazz 待转换Java对象类型
     * @param <T> 待转换Java数据类型
     * @return Java对象
     */
    public static <T> T deserialize(String value, Class<T> clazz) {
        T object = null;
        try {
            object = OBJECT_MAPPER.readValue(value, clazz);
        } catch (IOException e) {
            log.error("json反序列化失败！error: {}", e.getMessage());
            e.printStackTrace();
        }
        return object;
    }

}
