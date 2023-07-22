package com.sgugo.sky.service.impl;

import com.sgugo.sky.service.EmployeeService;
import com.sgugo.sky.dto.EmployeeLoginDTO;
import com.sgugo.sky.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        // 1. 根据用户名查询用户数据信息


        // 2. 处理账号相关的异常：用户不存在、密码错误、账号被冻结


        //3. 返回Employee对象给Controller
        return null;
    }
}
