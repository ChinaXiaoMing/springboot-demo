package com.nexwise.controller.config;

import com.opencode.SpringbootDemoApplication;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description 配置加密测试类
 * @Author xiaoming
 * @Date 2020/6/6 14:44
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class ConfigTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptorTest() {
        String result = stringEncryptor.encrypt("yourPassword");
        System.out.println(result);
    }

}
