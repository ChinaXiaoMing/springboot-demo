package com.opencode.controller;

import com.opencode.common.Result;
import com.opencode.entity.User;
import com.opencode.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping(value = "/{username}")
    public Result<User> selectUserByUsername(@PathVariable String username) {
        return Result.success(userService.selectUserByUsername(username));
    }

}
