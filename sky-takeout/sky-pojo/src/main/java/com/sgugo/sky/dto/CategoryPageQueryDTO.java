package com.sgugo.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryPageQueryDTO implements Serializable {

    //查询第几页
    private int page;

    //每页显示几条数据
    private int pageSize;

    //可根据分类名称查询
    private String name;

    //可选择查询分类的类型
    private Integer type;

}
