package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    @Insert("INSERT INTO `users`  (name,  password) VALUES (#{name}, #{password})")
    int addUser(User c);
}
