package com.hundsun.operation.manager.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * JWT 工具类
 * @author Ryan
 * @date 2019-01-14.
 */
public class JwtUtils {

    static String algorithm = "HmacSHA256";
    public static String genJwt(String userKey,String jwtSecret,int offetSecond){
        try {
            Date now = DateUtils.getCurrDate();
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            Date expiredDate = DateUtils.addSecond(now,offetSecond);
            String jwt = JWT.create().withIssuer(userKey).withIssuedAt(now).withExpiresAt(expiredDate).sign(algorithm);
            return jwt;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }



}
