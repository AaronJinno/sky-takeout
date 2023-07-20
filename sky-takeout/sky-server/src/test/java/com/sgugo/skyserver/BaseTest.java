package com.sgugo.skyserver;



import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@SpringBootTest
@Log4j2
public class BaseTest {
    // 指定签名的时候使用的签名算法，也就是header那部分


    @Test
    void test1() throws JsonProcessingException {
        //1. 设置Header部分: 设置签名算法
        SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

        // 设置秘钥：可以同时设置一个固定的秘钥，用于加盐
        String secret = "sky";

        //2. 设置Payload 部分：这里是要动态指定的，值不能写死
        Map<String, Object> claims = new HashMap<>();
        //2.1 添加Payload中的字段
            //可以不在这里指定，而是用Jwts.builder的API指定

        // 2.2 根据业务添加自定义数据
        claims.put("id","1234");
        claims.put("username","Aaron");


        // 3. 使用Jwts。builder()创建token
        String token = Jwts.builder()
                //设置签名算法，同时可以自定一个秘钥（加盐）
                .signWith(SIGNATURE_ALGORITHM, secret.getBytes(StandardCharsets.UTF_8))
                //设置payload
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7200000))
                .compact();
        System.out.println(token);
    }

    @Test
    void test2(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEyMzQiLCJleHAiOjE2ODk4NTU5OTUsImlhdCI6MTY4OTg0ODc5NSwianRpIjoiODY0NzUyY2YtNDA5Yi00NDNjLWFkYzUtMDcyOTVlZmEzMTUwIiwidXNlcm5hbWUiOiJBYXJvbiJ9.J2bY633peUdBEdJOxveoWLIRePrfVO8TNzcd_5f3kVs";

        String secret = "sky";

        Claims claims = null;

        try{
            claims = Jwts.parser()
                    .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println(claims);
            System.out.println(claims.getId());
            System.out.println(claims.get("username"));
        }catch(Exception e){
            //抛出异常说明TOKEN签名是错误的，校验失败
            System.out.println("Token校验失败，请重新登陆");
        }
    }
}
