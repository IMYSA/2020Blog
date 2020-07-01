package com.shixun.blog.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shixun.blog.entity.User;
import com.shixun.blog.mapper.userInfoMapper;
import com.shixun.blog.service.UserInfoService;
import com.shixun.blog.service.impl.UserInfoServiceImpl;
import com.sun.net.httpserver.Authenticator;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


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
        return userinfomapper.getUser(u.getId());
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public int Login(@RequestBody User u){
        if(userinfomapper.getUser(u.getName()) == null){
            return -100;
        }
        else {
            if(u.getPassword().equals(userinfomapper.getUser(u.getName()).getPassword()) ){
                return userinfomapper.getUser(u.getName()).getId();
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




}
