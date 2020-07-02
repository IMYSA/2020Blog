package com.shixun.blog.mapper;

import java.util.List;
import com.shixun.blog.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



@Mapper
public interface CommentInfoMapper {
    @Insert("INSERT INTO `comment` ( content, time, author, article) VALUES ( #{content}, #{time}, #{author}, #{articleId})")
    void AddComment(Comment comment);

    @Select("select * from `comment` where article = #{articleId}")
    List<Comment> GetCommentByArticle(int articleId);

    @Select("select * from `comment` where author = #{author}")
    List<Comment> GetCommentByAuthor(String author);
}
