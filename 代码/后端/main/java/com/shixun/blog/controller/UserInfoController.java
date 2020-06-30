package com.shixun.blog.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shixun.blog.entity.User;
import com.shixun.blog.mapper.userInfoMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@ResponseBody
@RestController
@CrossOrigin("http://localhost:8088")
public class UserInfoController {
    @Resource
    private userInfoMapper userinfomapper;

    @RequestMapping(value = "/user/update_user_info", method = RequestMethod.POST)
    public String updateUserInfo(@RequestBody User u){

        userinfomapper.updateUserInfo(u);
        return "修改信息成功";
    }

    @RequestMapping(value = "/user/get_user_info",method = RequestMethod.POST)
    public User getUserInfo(@RequestParam("id") String id){
        return userinfomapper.getUserInfo(Integer.parseInt(id));
    }

}
