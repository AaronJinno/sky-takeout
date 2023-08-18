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

    /**
     * 启用禁用员工在账号
     * @param status 员工状态，1启用，0禁用
     * @param id 被操作的员工id
     */
    void startOrStop(Integer status, Long id);


    /**
     * 根据id查询员工
     * @param id 员工的id
     * @return 员工的信息
     */
    Employee getById(Long id);

    /**
     * 编辑员工信息
     * @param employeeDTO DTO
     */
    void update(EmployeeDTO employeeDTO);
}
