package com.nexwise.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.nexwise.entity.User;
import com.nexwise.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    private static ObjectMapper objectMapper;

    @GetMapping
    public String findUserListByPage(@RequestParam(value = "start", required = false, defaultValue = "1") int start,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) throws JsonProcessingException {
        PageInfo<User> pageInfo = userService.findUserByPage(start, pageSize);
        return JSON.toJSONString(pageInfo);
    }

    @GetMapping(value = "/{id}")
    public String findUserById(@PathVariable long id) {
        return null;
    }

}
