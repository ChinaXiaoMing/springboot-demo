package com.opencode.controller;

import com.opencode.common.Result;
import com.opencode.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 *
 * @author xiaoming
 * @date 2021/05/19
 */
@RestController
@RequestMapping()
@Api(tags = "登录管理API")
public class LoginController {

	@PostMapping("/login")
	public Result<String> login(@RequestBody User user) {
		return null;
	}

}
