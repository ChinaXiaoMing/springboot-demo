package com.opencode.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/6/3 23:02
 * @Version 1.0
 **/
@Component
public class RedisUtils {

    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Autowired
    private RedisTemplate redisTemplate;

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
        logger.info("数据成功保存到redis中！");
    }

    public void delete(String key) {
        if (redisTemplate.delete(key)) {
            logger.info("Delete redis key: {} is success!", key);
        } else {
            logger.error("Delete redis key: {} is failure!", key);
        }
    }

}
