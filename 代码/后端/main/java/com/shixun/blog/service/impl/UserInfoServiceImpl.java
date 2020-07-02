package com.shixun.blog.service.impl;

import com.shixun.blog.entity.User;
import com.shixun.blog.mapper.userInfoMapper;
import com.shixun.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}
