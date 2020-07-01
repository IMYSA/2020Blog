package com.shixun.blog.controller;

import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.User;
import com.shixun.blog.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@ResponseBody
@RestController
@CrossOrigin()
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @RequestMapping(value = "/add_article",method = RequestMethod.POST)
    int addArticle(@RequestBody Article a){
        System.out.println(a.getContent_html());
        return articleService.addArticle(a);

    }

    @RequestMapping(value = "/get_articles", method = RequestMethod.POST)
    List<Article> getArticles(@RequestBody User u){
        return articleService.getArticlesByAuthorId(u.getId());
    }

    @RequestMapping(value = "/get_article", method = RequestMethod.POST)
    Article getArticles(@RequestBody Article a){
        return articleService.getArticlesById(a.getId());
    }

}
