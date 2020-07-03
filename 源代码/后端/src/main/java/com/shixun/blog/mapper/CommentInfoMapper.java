package com.shixun.blog.mapper;

import com.shixun.blog.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentInfoMapper {
    @Insert("INSERT INTO `comment` ( content, time, author_id, article_id) VALUES ( #{content}, #{time}, #{author_id}, #{article_id})")
    void AddComment(Comment comment);

    @Select("select * from `comment` where article_id = #{article_id}")
    List<Comment> GetCommentById(int articleId);

    @Select("select * from `comment` where author_id = #{author_id}")
    List<Comment> GetComments(int author_id);
}
