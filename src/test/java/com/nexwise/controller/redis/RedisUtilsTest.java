package com.nexwise.controller.redis;

import com.opencode.SpringbootDemoApplication;
import com.opencode.redis.Person;
import com.opencode.redis.RedisUtils;
import com.opencode.utils.JsonUtils;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @Description redis操作测试类
 * @Author xiaoming
 * @Date 2020/6/6 14:43
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class RedisUtilsTest {

    private Logger logger = LoggerFactory.getLogger(RedisUtilsTest.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void setStringTest() {
        Person person = new Person();
        person.setId(1L);
        person.setName("xiaoming");
        person.setAge(27);
        String value = JsonUtils.serialize(person);
        redisTemplate.opsForValue().set(person.getId().toString(), value);
    }

    @Test
    public void getStringTest() {
        String value = (String) redisTemplate.opsForValue().get(1);
        logger.info("redis value: {}", value);
    }

    @Test
    public void deleteByKeyTest() {
        Long key = 1L;
        if (redisTemplate.delete(key)) {
            logger.info("Delete redis key: {} is success!", key);
        } else {
            logger.error("Delete redis key: {} is failure!", key);
        }
    }

    @Test
    public void getListTest() {
        Set<ZSetOperations.TypedTuple> set = new HashSet<>();
        DefaultTypedTuple<Object> math = new DefaultTypedTuple<>("math", 99.0);
        DefaultTypedTuple<String> chinese = new DefaultTypedTuple<>("chinese", 98.5);
        set.add(chinese);
        set.add(math);
        redisTemplate.opsForZSet().add("course", set);
    }

    @Test
    public void selectListTest() {
        String key = "nameList";
        List list = redisTemplate.opsForList().range(key, 0, -1);
        list.forEach(x -> System.out.println(x));
    }


    @Test
    public void setTest() {
        String key = "map";
//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        redisUtils.addCollection(key, set);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "xiaoming");
        map.put("age", 27);
        redisUtils.set("hello", "world");
    }

}
