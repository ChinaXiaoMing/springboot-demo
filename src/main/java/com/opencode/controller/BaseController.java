package com.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基本控制器
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@RestController
public class BaseController {

    @GetMapping(value = "/404")
    public String pageNotFound() {
        return "页面找不到！";
    }

}
