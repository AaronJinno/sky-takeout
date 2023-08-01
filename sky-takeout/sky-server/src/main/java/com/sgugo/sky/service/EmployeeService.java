package com.sgugo.sky.service;

import com.sgugo.sky.dto.EmployeeDTO;
import com.sgugo.sky.dto.EmployeeLoginDTO;
import com.sgugo.sky.dto.EmployeePageQueryDTO;
import com.sgugo.sky.entity.Employee;
import com.sgugo.sky.vo.PageResultVO;

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

    /**
     * 新增员工
     * @param employeeDTO DTO
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 员工分页查询
     * @param employeePageQueryDTO DTO
     * @return VO
     */
    PageResultVO pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

}
