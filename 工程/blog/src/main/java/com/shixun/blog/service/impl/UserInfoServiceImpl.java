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
    public User getUser(int id) {
        return userinfomapper.getUser(id);
    }

    @Override
    public User getUser(String name) {
        return userinfomapper.getUser(name);
    }

    @Override
    public int addUser(User u) {
        if(userinfomapper.getUser(u.getName()) == null){
            userinfomapper.addUser(u);
            return userinfomapper.getUser(u.getName()).getId();
        }else{
            return -100;
        }
    }

}
