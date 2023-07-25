package com.sgugo.sky.controller.admin;

import com.sgugo.sky.result.R;
import com.sgugo.sky.dto.EmployeeLoginDTO;
import com.sgugo.sky.vo.EmployeeLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 员工登录接口
     * @param employeeLoginDTO 员工登录的DTO
     * @return 员工登录后的信息
     */
    @Operation(description = "员工登录")
    @PostMapping("/login")
    public R<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO){
        log.info("员工登录");
        return R.success();
    }

    @PostMapping("/logout")
    public R<String> logout(){
        log.info("员工退出");
        return R.success();
    }
}
