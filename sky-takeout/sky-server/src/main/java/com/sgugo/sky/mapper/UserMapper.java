package com.sgugo.sky.mapper;

import com.sgugo.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    /**
     * 添加一个用户
     * @return 返回影响的行数，>0表示插入成功，0表示插入失败
     */
    int insertUser(User user);


    /**
     * 根据id删除一个用户
     * @param id 用户的id
     * @return 返回操作影响的行数，>0表示删除成功，0表示删除失败
     */
    int deleteUser(long id);

    int updateUser(User user,long id);

    /**
     * 根据id 查询用户信息
     * @param id 用户id
     * @return 用户细腻系
     */
    User getUserById(Long id);


}
