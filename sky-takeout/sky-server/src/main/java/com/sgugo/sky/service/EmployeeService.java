package com.sgugo.sky.service;

import com.sgugo.sky.dto.EmployeeLoginDTO;
import com.sgugo.sky.entity.Employee;

public interface EmployeeService {
    Employee login(EmployeeLoginDTO employeeLoginDTO);
}
