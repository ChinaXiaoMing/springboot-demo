package com.opencode.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 加密工具类
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
public class EncryptUtils {

    /**
     * MD5密码加密（不加盐）
     *
     * @param password 明文密码
     * @return 16进制密文密码
     */
    public static String md5Encrypt(String password) {
        return new SimpleHash("MD5", password).toHex();
    }

    /**
     * MD5密码加密（密码加盐混合）
     *
     * @param password 明文密码
     * @param salt 盐值
     * @return 16进制密文密码
     */
    public static String saltMd5Encrypt(String password, String salt) {
        return new SimpleHash("MD5", password, ByteSource.Util.bytes(salt)).toHex();
    }

}
