package com.opencode.entity;

/**
 * jwt用户工厂
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
public class JwtUserFactory {

    private JwtUserFactory() {}

    public static JwtUser createJwtUser(User user) {
        return new JwtUser(user.getId(), user.getUsername(), user.getPassword());
    }

}
