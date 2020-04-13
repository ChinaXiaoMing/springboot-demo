package com.opencode.service;

import com.opencode.dao.UserMapper;
import com.opencode.entity.User;
import com.opencode.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description DOTO
 * @Author xiaoming
 * @Date 2020/4/2 20:35
 * @Version 1.0
 **/
@Service
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;

    public User selectUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

}
