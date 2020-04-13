package com.opencode.controller;

import com.opencode.common.Result;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 登录控制层
 * @Author xiaoming
 * @Date 2020/4/4 17:02
 * @Version 1.0
 **/
@Controller
public class LoginController {

    @GetMapping(value = {"/login", "/"})
    public String toLoginPage() {
        return "login";
    }

    @GetMapping(value = "/home")
    public String success() {
        return "home";
    }

    @GetMapping(value = "/login/error")
    @ResponseBody
    public Result loginError(HttpServletRequest request) {
        AuthenticationException authenticationException = (AuthenticationException) request.getSession()
                .getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        if (authenticationException instanceof BadCredentialsException) {
            return Result.failure("登录失败！用户名或密码错误！");
        }
        return Result.failure();
    }

}
