package com.nexwise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nexwise.service.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @Autowired
    DeviceServiceImpl deviceService;

    @GetMapping(value = "/device")
    public String findDeviceByPage(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        String result = null;
        try {
            result = deviceService.findDeviceByPage(page, pageSize);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
