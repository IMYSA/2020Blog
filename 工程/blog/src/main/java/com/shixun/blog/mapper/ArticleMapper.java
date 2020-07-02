package com.shixun.blog.mapper;

import java.util.List;

import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface ArticleMapper {
    @Insert("INSERT INTO `article` (title, author, description, content_md, content_html) VALUES (#{title}, #{author},#{description}, #{content_md},#{content_html})")
    void addArticle(Article a);

    @Select("Select * from `article` where author = #{author}")
    List<Article> getArticlesByAuthorId(int author);

    @Select("Select * from `article` where id = #{id}")
    Article getArticlesById(int id);

    @Select("Select * from `article` where isAudit = #false")
    List<Comment> GetPendingAritcles();
}
