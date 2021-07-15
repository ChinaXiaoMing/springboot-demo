package com.opencode.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt token工具类
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Slf4j
public class JwtTokenUtils {

    public static String createJwtToken(Map<String, Object> claims) {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("C*F-JaNdRgUkXn2r5u8x/A?D(G+KbPeShVmYq3s6v9y$B&E)H@McQfTjWnZr4u7w");
        SecretKey secretKey = Keys.hmacShaKeyFor(apiKeySecretBytes);
        return Jwts.builder().setClaims(claims).signWith(secretKey, SignatureAlgorithm.HS256).compact();
    }

    public static void main(String[] args) {
        HashMap<String, Object> claim = new HashMap<>();
        claim.put("username", "xiaoming");
        String jwtToken = JwtTokenUtils.createJwtToken(claim);
        log.info(jwtToken);
    }

}
