package com.sgugo.sky.service;

import com.sgugo.sky.dto.EmployeeLoginDTO;
import com.sgugo.sky.entity.Employee;

/**
 * 员工业务接口
 */
public interface EmployeeService {
    /**
     * 员工登录
     * @param employeeLoginDTO DTO
     * @return 员工实体类
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);
}
