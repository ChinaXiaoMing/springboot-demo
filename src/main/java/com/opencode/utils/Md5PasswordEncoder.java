package com.opencode.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description 加密工具类
 * @Author xiaoming
 * @Date 2020/4/4 15:11
 * @Version 1.0
 **/
public class Md5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return EncryptUtils.md5Encrypt(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(encode(rawPassword));
    }
}
