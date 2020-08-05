package com.opencode.controller;

import com.opencode.common.Result;
import com.opencode.entity.User;
import com.opencode.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description DOTO
 * @Author xiaoming
 * @Date 2020/4/2 20:36
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{username}")
    public Result selectUserByUsername(@PathVariable String username) {
        User user = userService.selectUserByUsername(username);
        if (user == null) {
            return Result.failure("用户名不存在！");
        }
        return Result.success(user);
    }


}
