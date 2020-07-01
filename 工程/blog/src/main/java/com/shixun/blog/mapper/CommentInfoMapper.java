package com.shixun.blog.mapper;

import com.shixun.blog.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CommentInfoMapper {
    @Insert("INSERT INTO `comment` ( content, time, author, articleId) VALUES ( #{content}, #{time}, #{author}, #{articleId})")
    void AddComment(Comment comment);

    @Select("select * from `comment` where articleId = #{articleId}")
    List<Comment> GetComment(int articleId);

    @Select("select * from `comment` where author = #{author}")
    List<Comment> GetComment(String author);
}
