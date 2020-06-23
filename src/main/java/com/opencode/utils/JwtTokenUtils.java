package com.opencode.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.HashMap;

/**
 * @Description JWT生成工具类
 * @Author xiaoming
 * @Date 2020/6/23 10:59
 * @Version 1.0
 **/
public class JwtTokenUtils {

    public static String createJwtToken(HashMap<String, Object> claims) {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("C*F-JaNdRgUkXn2r5u8x/A?D(G+KbPeShVmYq3s6v9y$B&E)H@McQfTjWnZr4u7w");
        SecretKey secretKey = Keys.hmacShaKeyFor(apiKeySecretBytes);
        return Jwts.builder().setClaims(claims).signWith(secretKey, SignatureAlgorithm.HS256).compact();
    }

    public static void main(String[] args) {
        HashMap<String, Object> claim = new HashMap<>();
        claim.put("username", "xiaoming");
        String jwtToken = JwtTokenUtils.createJwtToken(claim);
        System.out.println(jwtToken);
    }

}
