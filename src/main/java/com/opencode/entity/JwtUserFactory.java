package com.opencode.entity;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/6/23 15:06
 * @Version 1.0
 **/
public class JwtUserFactory {

    private JwtUserFactory() {}

    public static JwtUser createJwtUser(User user) {
        return new JwtUser(user.getId(), user.getUsername(), user.getPassword());
    }

}
