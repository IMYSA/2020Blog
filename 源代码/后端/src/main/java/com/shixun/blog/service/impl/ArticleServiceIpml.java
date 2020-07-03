package com.shixun.blog.service.impl;

import com.shixun.blog.entity.Article;
import com.shixun.blog.mapper.ArticleMapper;

import com.shixun.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceIpml implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Override
    public int addArticle(Article a) {
        articleMapper.addArticle(a);
        return 0;
    }

    @Override
    public List<Article> getArticlesByAuthorId(int author) {
        List<Article> articles = articleMapper.getArticlesByAuthorId(author);
        return articles;
    }

    @Override
    public Article getArticlesById(int id) {
        return articleMapper.getArticlesById(id);
    }

    @Override
    public void updateArticle(Article a) {
        articleMapper.updateArticle(a);
    }

    @Override
    public void deleteArticle(int id) {
        articleMapper.deleteArticle(id);
    }
}
