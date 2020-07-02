package com.shixun.blog.mapper;


import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    @Update("update `article` set isAudit =#{isAudit} where id=#{id}")
    int AuditArticle(Article article);

    @Select("select * from `article` where isAudit = #false")
    List<Article> UpdatePending();

}
