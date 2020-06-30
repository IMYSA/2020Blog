package com.shixun.blog.mapper;


import com.shixun.blog.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface userInfoMapper {

    @Update("update `user` set avatar=#{avatar}, description=#{description} where id=#{id}")
    int updateUserInfo(User u);

    @Select("select * from `user` where id = #{id}")
    User getUserInfo(int id);
}
