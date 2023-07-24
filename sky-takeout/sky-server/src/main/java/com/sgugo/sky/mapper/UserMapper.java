package com.sgugo.sky.mapper;

import com.sgugo.sky.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> getUserByLike(@Param("name") String name);

    /**
     * 通过id列表批量删除数据
     * @param ids：字符串格式的id列表，id之间以逗号分割
     * @return 返回删除成功的个数
     */
    int deleteMore(@Param("ids") String ids);

    void insertUser(User user);

    List<User> getUserByTable(@Param("table") String table);
}
