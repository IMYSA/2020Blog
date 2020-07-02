package com.shixun.blog.service;

import com.shixun.blog.entity.Follow;

import java.util.List;

public interface FollowService {
    void addFollow(Follow f);
    Follow searchFollow(Follow f);
    void deleteFollow(Follow f);
    List<Follow> getFollows(Follow f);
}
