package com.shixun.blog.service;

import com.shixun.blog.entity.User;

public interface UserInfoService {
    int updateUserInfo(User u);
    User getUser(int id);
    User getUser(String name);
    int addUser(User u);
}


