package com.sgugo.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 统一封装分页查询结果的VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResultVO implements Serializable {

    //总记录数
    private long total;

    //当前页数据集合
    private List records;
}
