package com.sgugo.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {

    //分类ID：已设置为自增，不给值，或值为0，都会自增
    private Long id;

    //类型: 1 菜品分类 2 套餐分类
    private Integer type;

    //分类名称
    private String name;

    //排序
    private Integer sort;

}
