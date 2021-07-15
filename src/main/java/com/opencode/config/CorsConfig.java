package com.opencode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * cors跨域配置
 *
 * @author fu.yuanming
 * @date 2021-07-14
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //放行请求方法类型配置
        registry.addMapping("/**")
        .allowedMethods("GET","POST", "PUT", "DELETE");
    }
}
