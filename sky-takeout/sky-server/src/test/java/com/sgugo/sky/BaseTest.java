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
   void getUserById(){
        User user1 = mapper.getUserById(7L);
        System.out.println(user1);

        User user2 = mapper.getUserById(7L);
        System.out.println(user2);
    }
}
