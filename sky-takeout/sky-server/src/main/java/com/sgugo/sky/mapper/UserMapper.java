package com.sgugo.sky.mapper;

import com.sgugo.sky.entity.User;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    User getUserById(@Param("id")Long id);
}
