package com.sgugo.sky;



import com.sgugo.sky.entity.User;
import com.sgugo.sky.mapper.UserMapper;
import com.sgugo.sky.properties.JwtProperties;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;


@SpringBootTest
@Log4j2
public class BaseTest {

    @Autowired
    private UserMapper mapper;

    @Test
    void getUserByLike(){
        List<User> users = mapper.getUserByLike("Jin");
        System.out.println(users);
    }

    @Test
    void deleteMore(){
        int i = mapper.deleteMore("5,6");
        System.out.println(i);
    }


    @Test
    void insertUser(){
        User user = new User(null,null, "Mike", "911", null, null, null, null);
        mapper.insertUser(user);

        System.out.println(user.getId()); //打印的User信息已经有id了
    }

    @Test
    void getUserByTable(){
        List<User> users = mapper.getUserByTable("user");
        System.out.println(users);
    }
}
