package com.opencode.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * json序列化与反序列化工具类
 *
 * @author fu.yuanming
 * @since 2020/6/6 11:24
 **/
public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * json序列化
     * @param object Java对象
     * @param <T> Java数据类型
     * @return json字符串
     */
    public static <T> String serialize(T object) {
        String value = null;
        try {
            value = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("json序列化失败！error: {}", e.getMessage());
        }
        return value;
    }

    /**
     * json反系列化
     * @param value json字符串
     * @param clazz 待转换Java对象类型
     * @param <T> 待转换Java数据类型
     * @return Java对象
     */
    public static <T> T deserialize(String value, Class<T> clazz) {
        T object = null;
        try {
            object = objectMapper.readValue(value, clazz);
        } catch (IOException e) {
            logger.error("json反序列化失败！error: {}", e.getMessage());
            e.printStackTrace();
        }
        return object;
    }

}
