package com.shixun.blog.service;

import com.shixun.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    int addArticle(Article a);
    List<Article> getArticlesByAuthorId(int author);
    Article getArticlesById(int id);
    void updateArticle(Article a);
    void deleteArticle(int id);
}
