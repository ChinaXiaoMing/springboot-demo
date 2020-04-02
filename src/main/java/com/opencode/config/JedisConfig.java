package com.opencode.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Descript Jedis连接池配置类
 * @Author fuyuanming
 * @Date 2018-06-28 09:05:49
 * @Version 1.0
 */
//@Configuration
public class JedisConfig {

    //地址
    @Value("${spring.redis.host}")
    private String host;
    //端口
    @Value("${spring.redis.port}")
    private int port;
    //密码
    @Value("${spring.redis.password}")
    private String password;
    //最大空闲连接数
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int maxIdle;
    //最小空闲连接数
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int minIdle;
    //最大连接数
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxTotal;

    /**
     * 注册jedis连接池
     * @return
     */
    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        //创建Jedis连接池
        return new JedisPool(jedisPoolConfig, host, port);
    }


}
