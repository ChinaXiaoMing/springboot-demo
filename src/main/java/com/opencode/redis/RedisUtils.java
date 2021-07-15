package com.opencode.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * redis工具类
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RedisUtils {

    private final RedisTemplate<String, Object> redisTemplate;

    public <T> void set(String key, T value) {
        if (value instanceof Map) {
            Map map = (Map) value;
            redisTemplate.opsForHash().putAll(key, map);
        }
        if (value instanceof Set) {
            Set set = (Set) value;
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                redisTemplate.opsForSet().add(key, iterator.next());
            }
        }
        if (value instanceof List) {
            List list = (List) value;
            redisTemplate.opsForList().leftPushAll(key, list);
        }
        if (value instanceof String) {
            redisTemplate.opsForValue().set(key, value);
        }
        log.info("数据成功保存到redis中！");
    }

    public void delete(String key) {
        if (Boolean.TRUE.equals(redisTemplate.delete(key))) {
            log.info("Delete redis key: {} is success!", key);
        } else {
            log.error("Delete redis key: {} is failure!", key);
        }
    }

}
