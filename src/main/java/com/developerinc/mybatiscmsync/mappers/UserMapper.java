// src/main/java/com/developerinc/mybatiscmsync/mappers/UserMapper.java
package com.developerinc.mybatiscmsync.mappers;

import com.developerinc.mybatiscmsync.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();
}