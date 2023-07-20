package com.sgugo.skyserver.service;

import com.sgugo.skypojo.dto.EmployeeLoginDTO;
import com.sgugo.skypojo.entity.Employee;

public interface EmployeeService {
    Employee login(EmployeeLoginDTO employeeLoginDTO);
}
