package com.shixun.blog.service;

import com.shixun.blog.entity.User;

public interface UserInfoService {
    int updateUserInfo(User u);
    User getUserInfo(int id);
    User getUserByName(String name);
    int addUser(User u);
}


