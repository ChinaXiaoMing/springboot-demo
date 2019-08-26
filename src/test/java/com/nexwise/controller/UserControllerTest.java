package com.nexwise.controller;

import com.nexwise.SpringbootDemoApplication;
import com.nexwise.dao.database1.UserMapper;
import com.nexwise.entity.User;
import com.nexwise.utils.EncryptUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest(classes = SpringbootDemoApplication.class)
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    UserMapper userMapper;

    @Test
    @Transactional
    public void addUser() {
        User user = new User();
        user.setUsername("xiaohua");
        user.setName("小花");
        user.setPassword(EncryptUtils.encryptPasswordByPassword("123456"));
        user.setSex(0);
        user.setStatus(1);
        user.setCreateTime(new Date());
        userMapper.insert(user);
        User user1 = new User();
        user1.setUsername("xiaojun");
        user1.setName("小军");
        user1.setPassword(EncryptUtils.encryptPasswordByPassword("123456"));
        user1.setSex(0);
        user1.setStatus(1);
        user1.setCreateTime(new Date());
        userMapper.insert(user1);
    }

}
