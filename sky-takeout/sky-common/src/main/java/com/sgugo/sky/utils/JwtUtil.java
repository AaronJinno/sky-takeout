package com.sgugo.sky.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类
 */
public class JwtUtil {

    /**
     * 使用Hs256算法,和配置文件中固定的秘钥生成jwt token
     * @param ttl 配置文件中设置的超时时间
     * @param secret 配置文件中自定的秘钥
     * @param claims JWT载荷中自定义的数据
     * @return 返回一个全新的JWT Token字符串
     */
    public static String createJWT(long ttl, String secret, Map<String,Object> claims){
        //1. 指定签名算法：这个也可以卸写在配置文件中
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //2. 生成JWT超时时间
        long ms = System.currentTimeMillis() + (ttl * 1000 * 60);
        Date exp = new Date(ms);

        //3. 设置jwt的属性
        String token = Jwts.builder()
                .signWith(signatureAlgorithm, secret.getBytes(StandardCharsets.UTF_8))
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(exp)
                .compact();

        return token;
    }

    /**
     * 解析 JWT Token 字符串的工具方法
     * @param secret 和加密是一致的jwt 秘钥
     * @param token 前端传递过来的待解密的token字符串
     * @return 返回claims对象，该对象为javabean，包含了JWT里所有设置的载荷信息
     * @throws Exception  在解析token时，若解析失败会抛出异常，表示该token是非法的，
     * 异常不会再这里处理，而是在token拦截器里处理。
     */
    public static Claims parseJWT(String secret,String token) throws Exception{
        Claims claims = Jwts.parser()
                .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }
}
