package com.nexwise.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping(value = "/404")
    public String error_404() {
        return "页面找不到！";
    }

}
