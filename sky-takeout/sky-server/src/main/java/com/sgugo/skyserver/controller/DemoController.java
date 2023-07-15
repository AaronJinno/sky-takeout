package com.sgugo.skyserver.controller;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.sgugo.skyserver.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
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
@Tag(name="Demo")

public class DemoController {

    @GetMapping("/test1")
    @ApiOperationSupport(author = "Victor",order = 20)
    @Operation(summary="Demo->test1",description ="Demo模块的第一个测试接口",tags="Test")
    @Parameter(name="para1",description="参数1",required=true,example="hello")
    @ApiResponse(responseCode = "200",description = "响应成功",content=@Content(
            schema = @Schema(implementation = Person.class)

    ))
    @ApiResponse(responseCode = "500",description = "响应失败",content=@Content(
            schema = @Schema(implementation = String.class)

    ))
    public void test1(String para1,Integer para2){
        System.out.println("hello,test1");
    }

    @GetMapping("/test0")
    @ApiOperationSupport(author = "Victor",order = 10)
    public void test2(Person person){
        System.out.println("hello,test2");
    }
}
