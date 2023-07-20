package com.sgugo.skyserver.mapper;

import com.sgugo.skypojo.entity.Employee;

public interface EmployeeMapper {

    Employee getByUsername(String username);
}
