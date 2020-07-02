package com.shixun.blog.mapper;

import com.shixun.blog.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentInfoMapper {
    @Insert("INSERT INTO `comment` ( content, time, author, article_id) VALUES ( #{content}, #{time}, #{author}, #{articleId})")
    void AddComment(Comment comment);

    @Select("select * from `comment` where articleId = #{articleId}")
    List<Comment> GetCommentById(int articleId);

    @Select("select * from `comment` where author = #{author}")
    List<Comment> GetComment(String author);
}
