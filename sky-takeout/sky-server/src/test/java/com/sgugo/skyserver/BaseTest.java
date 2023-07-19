package com.sgugo.skyserver;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
@Log4j2
public class BaseTest {

    public static <T> void fun1(T t){
        System.out.println(t);
    }

    public static <K,V> void fun2(K key,V value){
        System.out.println(key+":"+ value);
    }

    @Test
    void test1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        R<Object> success = R.success();
        R<Object> fail = R.fail(ErrorEnum.ERROR);

        String s1 = objectMapper.writeValueAsString(success);
        String s2 = objectMapper.writeValueAsString(fail);
        System.out.println(s1);
        System.out.println(s2);
    }

}
