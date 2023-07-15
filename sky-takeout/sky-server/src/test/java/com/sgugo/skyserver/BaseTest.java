package com.sgugo.skyserver;



import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
@Log4j2
public class BaseTest {

    @Test
    void LogTest(){
        log.trace("trace...");
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");
       //log.fatal，没有fatal方法
        log.fatal("fatal...");
    }

}
