package com.sgugo.sky.service.impl;

import com.sgugo.sky.constant.MessageConstant;
import com.sgugo.sky.exception.AccountLockedException;
import com.sgugo.sky.exception.AccountNotFoundException;
import com.sgugo.sky.exception.PasswordErrorException;
import com.sgugo.sky.mapper.EmployeeMapper;
import com.sgugo.sky.service.EmployeeService;
import com.sgugo.sky.dto.EmployeeLoginDTO;
import com.sgugo.sky.entity.Employee;
import com.sgugo.sky.utils.EncryptMd5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 员工业务处理类
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        //获取Controller传递的用户名和密码
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        // 1. 根据用户名查询用户数据信息
        Employee employee = employeeMapper.getByUsername(username);

        // 2. 处理账号相关的异常：用户不存在、密码错误、账号被冻结
        // 2.1 账号不存在
        if(employee == null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // 2.2 密码比对!
        if(!EncryptMd5.checkMd5Pass(password,employee.getPassword())){
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        //2.3 账号被冻结
        if(employee.getStatus() == 0){
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3. 返回Employee对象给Controller
        return employee;
    }
}
