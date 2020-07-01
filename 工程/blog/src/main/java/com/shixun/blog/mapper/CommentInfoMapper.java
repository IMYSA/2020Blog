package com.shixun.blog.mapper;

import com.shixun.blog.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommentInfoMapper {
    @Insert("INSERT INTO `comment` (id, content, time, author, articleId) VALUES (#{id}, #{content}, #{time}, #{author}, #{articleId})")
    void AddComment(Comment comment);

    @Select("select * from `comment` where articleId = #{articleId}")
    Comment GetComment(int articleId);

    @Select("select * from `comment` where author = #{author}")
    Comment GetComment(String author);
}
