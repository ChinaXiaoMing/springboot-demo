package com.nexwise.controller;

import com.alibaba.fastjson.JSON;
import com.nexwise.dao.UsersMapper;
import com.nexwise.entity.Users;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Descript 用户控制类
 * @Author fuyuanming
 * @Date 2018-07-03 16:36:53
 * @Version 1.0
 */
@Controller
@Api
@RequestMapping(value = "/user")
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public String findByName(@PathVariable("username") String username) {
        Users users = usersMapper.selectUserByUsername(username);
        String json = JSON.toJSONString(users);
        return json;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public int addUser() {
        Users users = new Users();
        users.setUsername("xiaohong");
        users.setPassword("123");
        int count = usersMapper.insert(users);
        String json = JSON.toJSONString(users);
        return count;
    }

}
