package com.shixun.blog.service.impl;

import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.User;
import com.shixun.blog.mapper.ArticleMapper;
import com.shixun.blog.mapper.userInfoMapper;
import com.shixun.blog.service.UserInfoService;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {



    @Resource
    private userInfoMapper userinfomapper;

    public int updateUserInfo(User u) {
        return userinfomapper.updateUserInfo(u);
    }

    @Override
    public User getUserInfo(int id) {
        return userinfomapper.getUserInfo(id);
    }

    @Override
    public User getUserByName(String name) {
        return userinfomapper.getUserByName(name);
    }

    @Override
    public int addUser(User u) {
        if(userinfomapper.getUserByName(u.getName()) == null){
            userinfomapper.addUser(u);
            return userinfomapper.getUserByName(u.getName()).getId();
        }else{
            return -100;
        }
    }
    @Override
    public int AuditArticle(Article article)
    {
        article.setAudit(true);
        return userinfomapper.AuditArticle(article);
    }
    @Override
    public List<Article> UpdatePending(){
        return userinfomapper.UpdatePending();
    }
}
