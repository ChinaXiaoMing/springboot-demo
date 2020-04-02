package com.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping(value = "/404")
    public String pageNotFound() {
        return "页面找不到！";
    }

}
