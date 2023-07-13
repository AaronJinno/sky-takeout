package com.sgugo.skyserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class BaseTest {

    @Test
    void jsonTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        Person person = new Person("Jinno", 12, new Date());

        map.put("code",200);
        map.put("msg","ok");
        map.put("data",person);

        String jsonString = objectMapper.writeValueAsString(map);

        JsonNode jsonNode = objectMapper.readTree(jsonString);
        JsonNode code = jsonNode.get("code");
        int codeToInt = code.asInt();
        System.out.println(codeToInt);

        JsonNode data = jsonNode.get("data");
        JsonNode username = data.get("username");
        String usernameToString = username.asText();
        System.out.println(usernameToString);

//        Map<String, Object> mapResult = objectMapper.readValue(jsonString, Map.class);
//
//        System.out.println(jsonString);
//        System.out.println(mapResult);

    }
}
