package com.sgugo.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sgugo.sky.constant.MessageConstant;
import com.sgugo.sky.context.BaseContext;
import com.sgugo.sky.dto.CategoryDTO;
import com.sgugo.sky.dto.CategoryPageQueryDTO;
import com.sgugo.sky.entity.Category;
import com.sgugo.sky.exception.DeletionNotAllowedException;
import com.sgugo.sky.mapper.CategoryMapper;
import com.sgugo.sky.mapper.DishMapper;
import com.sgugo.sky.service.CategoryService;
import com.sgugo.sky.vo.PageResultVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DishMapper dishMapper;

    /**
     * 新增分类
     * @param categoryDTO DTO
     */
    @Override
    public void save(CategoryDTO categoryDTO) {

        Category category = new Category();

        BeanUtils.copyProperties(categoryDTO,category);

        //分类默认状态设置为 禁用（0）
        category.setStatus(0);
        //设置创建时间、修改时间、创建人、修改人
        // category.setCreateTime(LocalDateTime.now());
        // category.setUpdateTime(LocalDateTime.now());
        // category.setCreateUser(BaseContext.getId());
        // category.setUpdateUser(BaseContext.getId());

        //调用DAO完成数据插入

        categoryMapper.insert(category);
    }

    /**
     * 分页查询
     * @param categoryPageQueryDTO DTO
     * @return VO
     */
    @Override
    public PageResultVO pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());

        //调用Mapper进行分页查询
        Page<Category> page = categoryMapper.pageQuery(categoryPageQueryDTO);

        //获取数据，填充分页通用VO
        return new PageResultVO(page.getTotal(),page.getResult());
    }

    /**
     * 根据ID删除分类，不能随便删除，分类是空的，没有关联菜品，才能删除
     * @param id 分类id
     */
    @Override
    public void deleteById(Long id) {
        //删除前调用DishMapper，查询下当前分类是否关联了菜品，每关联才能删除
        Integer count = dishMapper.countByCategoryId(id);
        if(count > 0){
            //当前分类下有菜品，不能删除
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_DISH);
        }

        //调用Mapper删除该分类
        categoryMapper.deleteById(id);
    }

    /**
     * 更新分类
     * @param categoryDTO DTO
     */
    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = new Category();

        BeanUtils.copyProperties(categoryDTO,category);

        //设置修改时间、修改人
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getId());

        categoryMapper.update(category);
    }

    /**
     * 启用禁用分类
     * @param status 当前分类的状态
     * @param id 分类的id
     */
    @Override
    public void startOrStop(Integer status, Long id) {
        Category category = new Category();
        category.setId(id);
        category.setStatus(status);

        categoryMapper.update(category);
    }
}
