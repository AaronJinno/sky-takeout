package com.sgugo.sky;



import com.sgugo.sky.entity.User;
import com.sgugo.sky.mapper.UserMapper;
import com.sgugo.sky.properties.JwtProperties;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@SpringBootTest
@Log4j2
public class BaseTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    void insertUser(){
        User user = new User(null, "Jinno", "18888888888", "男", null, null, LocalDateTime.now());
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }

    @Test
    void deleteUser(){
        int i = userMapper.deleteUser(4);
        System.out.println(i);
    }

    @Test
    void updateUser(){
        User user = new User(null, null, "16666666666", null, null, null, null);
        int i = userMapper.updateUser(user,6);
        System.out.println(i);
    }





}
