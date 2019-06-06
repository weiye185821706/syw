package com.syw.baobao.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.syw.baobao.demo.contants.CommonContants;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TokenUtil {
    /**
     * 生成token字符串
     * @param name 账号
     * @param password 密码
     * @return
     */
    public static String sign(String name, String password, String userName, String uuid) {
        try {
            // 设置过期日期
            Date date = new Date(System.currentTimeMillis() + CommonContants.EXPIRE_TIME);
            // 私密加密算法
            Algorithm algorithm = Algorithm.HMAC256(CommonContants.TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> heaer = new HashMap<>();
            heaer.put("Type", "Jwt");
            heaer.put("alg", "HS256");

            // 返回token字符串
            return JWT.create()
                    .withKeyId(uuid)
                    .withAudience(userName)
                    .withHeader(heaer).withClaim("userName", name).withClaim("pwd", password)
                    .withExpiresAt(date).sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 验证token是否正确
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(CommonContants.TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
