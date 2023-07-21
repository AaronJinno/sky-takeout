package com.sgugo.skyserver;



import com.sgugo.skycommon.properties.JwtProperties;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
@Log4j2
public class BaseTest {

    @Resource
    private JwtProperties jwtProperties;



    @Test
    void test1() {
        String name = jwtProperties.getAdminSecret();
        System.out.println(name);
//        System.out.println(tokenProperties.getAdminSecret());
    }





}
