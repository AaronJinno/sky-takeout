package com.sgugo.sky.controller.admin;

import com.sgugo.sky.constant.JwtClaimsConstant;
import com.sgugo.sky.dto.EmployeeDTO;
import com.sgugo.sky.dto.EmployeePageQueryDTO;
import com.sgugo.sky.entity.Employee;
import com.sgugo.sky.properties.JwtProperties;
import com.sgugo.sky.result.R;
import com.sgugo.sky.dto.EmployeeLoginDTO;
import com.sgugo.sky.service.EmployeeService;
import com.sgugo.sky.utils.JwtUtil;
import com.sgugo.sky.vo.EmployeeLoginVO;
import com.sgugo.sky.vo.PageResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *  员工管理接口
 */
@RestController
@RequestMapping("/admin/employee")
@Log4j2
@Tag(name="Admin")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtProperties jwtProperties;
    /**
     * 员工登录接口
     * @param employeeLoginDTO 员工登录的DTO
     * @return 员工登录后的信息
     */
    @Operation(description = "员工登录")
    @PostMapping("/login")
    public R<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO){
        log.info("员工登录");

        // 1. 调用service进行登录
        Employee employee = employeeService.login(employeeLoginDTO);

        //2. 登录成功后，生成JWT令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminTtl(),
                jwtProperties.getAdminSecret(),
                claims);

        //3. 填充要响应的VO
        EmployeeLoginVO VO = new EmployeeLoginVO(employee.getId(), employee.getUsername(), employee.getName(), token);

        return R.success(VO);
    }

    @PostMapping("/logout")
    public R<String> logout(){
        log.info("员工退出");
        return R.success();
    }

    /**
     * 新增员工
     * @param employeeDTO DTO
     * @return 新增是否成功
     */
    @PostMapping
    @Operation(summary = "save->添加员工",description = "添加员工")
    public R save(@RequestBody EmployeeDTO employeeDTO){
        log.info("新增员工:{}",employeeDTO);
        employeeService.save(employeeDTO);
        return R.success();
    }


    /**
     * 员工分页查询
     * @param employeePageQueryDTO DTO
     * @return R
     */
    @GetMapping("/page")
    @Operation(summary = "page->员工分页查询",description = "查询员工")
    public R<PageResultVO> page(EmployeePageQueryDTO employeePageQueryDTO){
        log.info("员工分页查询，参数为：{}", employeePageQueryDTO);

        PageResultVO VO = employeeService.pageQuery(employeePageQueryDTO);
        return R.success(VO);
    }

}
