package com.sgugo.skyserver.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Aaron Jinno
 * @Description: TODO
 * @Date: 2023/7/13 22:02
 * @Since 1.0
 * @Version: 1.0
 */
@RestController
@RequestMapping("/")
//@Tag(name="Body")
public class DemoController {
    @GetMapping("/test1")
    @ApiOperationSupport(author = "AaronJinno")
    public void test1(){
        System.out.println("hello,test1");
    }
}
