package com.sgugo.sky.service;

import com.sgugo.sky.dto.CategoryDTO;
import com.sgugo.sky.dto.CategoryPageQueryDTO;
import com.sgugo.sky.vo.PageResultVO;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    /**
     * 新增分类
     * @param categoryDTO DTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 分页查询
     * @param categoryPageQueryDTO DTO
     * @return VO
     */
    PageResultVO pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据ID删除分类
     * @param id 分类id
     */
    void deleteById(Long id);

    /**
     * 修改分类
     * @param categoryDTO DTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 启用禁用分类
     * @param status 当前分类的状态
     * @param id 分类的id
     */
    void startOrStop(Integer status, Long id);
}
