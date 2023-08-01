package com.sgugo.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeePageQueryDTO implements Serializable {
    //员工姓名
    private String name;

    //要显示的页码
    private int page;

    //每页显示的记录数
    private int pageSize;
}
