package com.opencode.controller;

import com.opencode.common.Result;
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

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/{id}")
    public Result selectUserById(@PathVariable long id) {
        return Result.success(userService.selectUserById(id));
    }

}
