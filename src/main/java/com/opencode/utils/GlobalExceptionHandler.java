package com.opencode.utils;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author fu.yuanming
 * @since 2020-04-13 20:32:44
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Object defaultErrorHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return "我是一个异常处理类";
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer() {
        return (factory -> {
            ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
            factory.addErrorPages(errorPage);
        });
    }

}
