package com.shixun.blog.mapper;

import com.shixun.blog.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Insert("INSERT INTO `article` (title, author, description, content_md, content_html) VALUES (#{title}, #{author},#{description}, #{content_md},#{content_html})")
    void addArticle(Article a);

    @Select("Select * from `article` where author = #{author}")
    List<Article> getArticlesByAuthorId(int author);

    @Select("Select * from `article` where id = #{id}")
    Article getArticlesById(int id);

    @Update("update `article` set title=#{title}, description=#{description}, content_md=#{content_md}, content_html=#{content_html} where id=#{id}")
    void updateArticle(Article a);

    @Delete("delete from `article` where id = #{id}")
    void deleteArticle(int id);
}
