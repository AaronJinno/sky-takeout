package com.sgugo.skyserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class BaseTest {

    @Test
    void jsonTest() throws JsonProcessingException {
//        Person person = new Person("Jinno",12,new Date());


        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = objectMapper.writeValueAsString(person);
//        System.out.println(jsonString);

        String s = "{\"username\":\"Aaron\",\"age\":20,\"birthday\":1689155390494}";
        Person person = objectMapper.readValue(s, Person.class);
        System.out.println(person);
    }
}
