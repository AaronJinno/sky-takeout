package com.sgugo.sky.mapper;

import com.github.pagehelper.Page;
import com.sgugo.sky.dto.EmployeePageQueryDTO;
import com.sgugo.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username 用户名
     * @return 员工实体类对象
     */
    @Select("select * from employee where username=#{username}")
    Employee getByUsername(String username);

    @Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user,status) " +
            "values " +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    void insert(Employee employee);

    /**
     * 分页查询员工
     * @param employeePageQueryDTO DTO
     * @return 分页查询的Page类
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 根据主键动态修改属性
     * @param employee 员工实体类
     */
    void update(Employee employee);

    /**
     * 根据id查询员工信息
     * @param id 员工id
     * @return 员工实体类
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
