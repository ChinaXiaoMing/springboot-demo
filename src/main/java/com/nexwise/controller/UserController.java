package com.nexwise.controller;

import com.nexwise.dao.UsersMapper;
import com.nexwise.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UsersMapper usersMapper;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public String find() {
        Users users = usersMapper.selectUserByUsername("xiaoming");
        return users.getUsername();
    }

}
