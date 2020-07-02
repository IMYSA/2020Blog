package com.shixun.blog.mapper;


import com.shixun.blog.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface userInfoMapper {

    @Select("select * from `user` where name = #{name}")
    User getUserByName(String name);

    @Update("update `user` set name=#{name}, description=#{description} where id=#{id}")
    int updateUserInfo(User u);

    @Select("select * from `user` where id = #{id}")
    User getUserInfo(int id);

    @Insert("INSERT INTO `user` (name, password) VALUES (#{name}, #{password})")
    void addUser(User u);



}
