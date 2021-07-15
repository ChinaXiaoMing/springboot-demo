package com.opencode.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 加密工具类
 *
 * @author fu.yuanming
 * @since 2020/4/4 15:11
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
