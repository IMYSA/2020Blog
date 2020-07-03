package com.shixun.blog.controller;

import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.User;
import com.shixun.blog.mapper.ArticleMapper;
import com.shixun.blog.mapper.userInfoMapper;
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
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private userInfoMapper userInfoMapper;

    @RequestMapping(value = "/add_article",method = RequestMethod.POST)
    int addArticle(@RequestBody Article a){
        System.out.println(a.getContent_html());
        return articleService.addArticle(a);

    }

    @RequestMapping(value = "/get_articles", method = RequestMethod.POST)
    List<Article> getArticles(@RequestBody User u){
        System.out.println(u.getId());
        return articleService.getArticlesByAuthorId(u.getId());
    }

    @RequestMapping(value = "/get_article", method = RequestMethod.POST)
    Article getArticles(@RequestBody Article a){
        return articleService.getArticlesById(a.getId());
    }

    @RequestMapping(value = "/update_article", method = RequestMethod.POST)
    void updateArticles(@RequestBody Article a){
        System.out.println(a.getTitle());
        System.out.println(a.getId());
        articleService.updateArticle(a);
    }

    @RequestMapping(value = "/delete_article", method = RequestMethod.POST)
    void deleteArticle(@RequestBody Article a){
        articleService.deleteArticle(a.getId());
    }

    @RequestMapping(value = "/get_articles_all", method = RequestMethod.POST)
    List<Article> getAllArticle(){
        List<Article> alist = articleMapper.getAllArticles();
        for(Article item: alist){
            item.setAuthor_name(userInfoMapper.getUserInfo(item.getAuthor()).getName());
        }
        return alist;
    }

    @RequestMapping(value = "/set_ban", method = RequestMethod.POST)
    void setBan(@RequestBody Article a){
        articleMapper.setBan(a);
    }
}
