package com.opencode.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志切面
 *
 * @author fu.yuanming
 * @date 2021-07-14
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    private static Long start = 0L;

    @Pointcut(value = "execution(public * com.opencode.controller.*.*(..))")
    public void pointCut() {
        // Do nothing
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        start = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            log.info("url: {}", request.getRequestURL());
            log.info("method: {}", request.getMethod());
            log.info("ip: {}", request.getRemoteAddr());
            log.info("class: {}", joinPoint.getSignature().getDeclaringTypeName() + "."
                    + joinPoint.getSignature().getName());
            log.info("method args: {}", joinPoint.getArgs());
        }
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturning() {
        Long endTime = System.currentTimeMillis();
        log.info("method runtime: {}ms.", endTime - start);
    }

}
