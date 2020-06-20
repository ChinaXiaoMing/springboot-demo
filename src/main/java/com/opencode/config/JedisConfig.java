package com.opencode.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Descript Jedis连接池配置类
 * @Author fuyuanming
 * @Date 2018-06-28 09:05:49
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class JedisConfig {

    //redis服务器地址
    private String host;
    //redis服务器端口
    private int port;

    /**
     * 注册jedis连接池
     * @return
     */
    @Bean
    public JedisPool jedisPool() {
        return new JedisPool(new JedisPoolConfig(), host, port);
    }

    /**
     * redisTemplate配置
     * @param redisConnectionFactory redis连接工厂
     * @return redisTemplate实例
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        //jackson序列化器
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(objectMapper);

        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //使用jackson来序列化和反序列化redis的key、value
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);
        return redisTemplate;
    }

}
