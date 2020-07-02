package com.shixun.blog.service;

import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.User;

import java.util.List;

public interface UserInfoService {
    int updateUserInfo(User u);
    User getUserInfo(int id);
    User getUserByName(String name);
    int addUser(User u);
    int AuditArticle(Article article);
    List<Article> UpdatePending();
}


