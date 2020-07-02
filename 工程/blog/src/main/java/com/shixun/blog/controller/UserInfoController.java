package com.shixun.blog.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shixun.blog.entity.Article;
import com.shixun.blog.entity.User;
import com.shixun.blog.mapper.userInfoMapper;
import com.shixun.blog.service.UserInfoService;
import com.shixun.blog.service.impl.UserInfoServiceImpl;
import com.sun.net.httpserver.Authenticator;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


@ResponseBody
@RestController
@CrossOrigin()
public class UserInfoController {
    @Resource
    private userInfoMapper userinfomapper;
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/user/update_user_info", method = RequestMethod.POST)
    public String updateUserInfo(@RequestBody User u){

        userinfomapper.updateUserInfo(u);
        return "修改信息成功";
    }

    @RequestMapping(value = "/user/get_user_info",method = RequestMethod.POST)
    public User getUserInfo(@RequestBody User u){
        return userinfomapper.getUserInfo(u.getId());
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public int Login(@RequestBody User u){
        if(userinfomapper.getUserByName(u.getName()) == null){
            return -100;
        }
        else {
            if(u.getPassword().equals(userinfomapper.getUserByName(u.getName()).getPassword()) ){
                return userinfomapper.getUserByName(u.getName()).getId();
            }
            else {
                return -100;
            }
        }
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public int Register(@RequestBody User u)    {
        System.out.println(u.getPassword());
        return userInfoService.addUser(u);
    }

    @RequestMapping(value = "/administrator", method = RequestMethod.POST)
    public int AuditArticle(@RequestBody Article article){
        return userInfoService.AuditArticle(article);
    }
    @RequestMapping(value = "/administrator", method = RequestMethod.GET)
    public List<Article> UpdatePending(){
        return userInfoService.UpdatePending();
    }




}
