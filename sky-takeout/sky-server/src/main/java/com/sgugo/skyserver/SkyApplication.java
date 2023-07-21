package com.sgugo.skyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sgugo.skycommon")
public class SkyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyApplication.class,args);
    }
}
