package com.sgugo.skyserver.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name="Demo")
@ApiSupport(author="Victor", order=21)
public class UserController {
    @GetMapping("/login")
    @ApiOperationSupport(author = "AaronJinno")
    public void login(){
        System.out.println("hello,test1");
    }
}
