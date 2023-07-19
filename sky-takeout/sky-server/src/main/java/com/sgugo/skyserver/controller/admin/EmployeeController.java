package com.sgugo.skyserver.controller.admin;

import com.sgugo.skyserver.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  员工管理接口
 */
@RestController
@RequestMapping("/admin/employee")
@Log4j2
@Tag(name="Admin")
public class EmployeeController {

    @Operation(description = "员工登录")
    @PostMapping("/login")
    public R<Object> login(){
        log.info("员工登录");

        return R.success();
    }
}
