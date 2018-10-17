package com.nexwise.controller;

import com.nexwise.entity.Users;
import com.nexwise.utils.EncryptUtils;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Descript 登录控制类
 * @Author fuyuanming
 * @Date 2018-07-05 15:18:59
 * @Version 1.0
 */
@Controller
@Api
public class LoginController {

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = {"/", "", "/login"}, method = RequestMethod.GET)
    public String toLoginPage() {
        return "login";
    }

    /**
     * 登录操作
     * @return
     */
    @RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
    @ResponseBody
    public String login(Users users) {
        Subject subject = SecurityUtils.getSubject();
        String encryptPassword = EncryptUtils.saltEncryptPasswordByPasswordAndUsername(users.getPassword(), users.getUsername());
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), encryptPassword);
        try {
            //登录认证
            subject.login(token);
            return "success";
        } catch (UnknownAccountException e) { //账号不存在
            return "unknownAccount";
        } catch (IncorrectCredentialsException e) { //密码错误
            return "passwordError";
        } catch (AuthenticationException e) { //其他认证错误
            return "unknownException";
        }
    }

}
