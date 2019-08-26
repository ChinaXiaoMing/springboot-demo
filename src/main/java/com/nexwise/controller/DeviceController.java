package com.nexwise.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.nexwise.entity.LbsDevice;
import com.nexwise.service.DeviceServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    DeviceServiceImpl deviceService;

    /**
     * 分页查询设备信息
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/device")
    public String findDeviceByPage(int page, int pageSize) {
        String result = null;
        try {
            result = deviceService.findDeviceByPage(page, pageSize);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 新增设备
     * @param lbsDevice
     * @return
     */
    @PostMapping(value = "/device")
    public int addDevice(LbsDevice lbsDevice) {
        return deviceService.addDevice(lbsDevice);
    }

    /**
     * 根据ID查询设备
     * @param id
     * @return
     */
    @GetMapping(value = "/device/{id}")
    public String getDeviceById(@PathVariable Long id) {
        return JSON.toJSONString(deviceService.getDeviceById(id));
    }

    @PutMapping(value = "/device")
    public String updateDevice(LbsDevice lbsDevice) {
        return JSON.toJSONString(deviceService.updateDevice(lbsDevice));
    }

    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "form")
    @PostMapping(value = "/device/delete")
    public String batchDeleteDevice(List<Long> id) {
        return JSON.toJSONString(deviceService.batchDeleteDevice(id));
    }

}
