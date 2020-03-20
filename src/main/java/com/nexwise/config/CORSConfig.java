package com.nexwise.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Descript CORS跨域配置类
 * @Author fuyuanming
 * @Date 2018-07-04 11:33:43
 * @Version 1.0
 */
@Configuration
public class CORSConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //放行请求方法类型配置
        registry.addMapping("/**")
        .allowedMethods("GET","POST", "PUT", "DELETE");
    }
}
