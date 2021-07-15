package com.opencode.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件控制器
 * 文件上传控制类
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@RestController
@Slf4j
public class FileController {

    @Value("${fileupload}")
    private String filePath;

    @RequestMapping(value = "/upload")
    public String uploadFile(@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        File dest = new File(filePath + fileName);
        //文件不存在，则新建文件夹
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            log.error("文件上传失败！");
        }

        return "文件上传成功";
    }

}
