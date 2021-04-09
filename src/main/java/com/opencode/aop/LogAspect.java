package com.opencode.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description 日志性能aop工具类
 * @Author xiaoming
 * @Date 2020/6/21 16:22
 * @Version 1.0
 **/
@Aspect
@Component
public class LogAspect {

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private static Long start = 0L;

    @Pointcut(value = "execution(public * com.opencode.controller.*.*(..))")
    public void pointCut() {}

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        start = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            logger.info("URL: {}", request.getRequestURL().toString());
            logger.info("HTTP_METHOD: {}", request.getMethod());
            logger.info("IP: {}", request.getRemoteAddr());
            logger.info("CLASS_METHOD: {}", joinPoint.getSignature().getDeclaringTypeName() + "."
                    + joinPoint.getSignature().getName());
            logger.info("ARGS: {}", Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturning() {
        Long endTime = System.currentTimeMillis();
        logger.info("SPEED_TIME: {} ms.", endTime - start);
    }

}
