package com.shixun.blog.service.impl;

import com.shixun.blog.entity.Follow;
import com.shixun.blog.mapper.FollowMapper;
import com.shixun.blog.mapper.userInfoMapper;
import com.shixun.blog.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {
    @Resource
    private FollowMapper followMapper;
    @Resource
    private userInfoMapper userInfoMapper;
    @Override
    public void addFollow(Follow f) {
        followMapper.addFollow(f);
    }

    @Override
    public Follow searchFollow(Follow f) {
        return followMapper.searchFollow(f);
    }

    @Override
    public void deleteFollow(Follow f) {
        followMapper.deleteFollow(f);
    }

    @Override
    public List<Follow> getFollows(Follow f) {
        List<Follow> list = followMapper.getFollows(f);
        for(Follow item : list){
            System.out.println(item.getId());
            System.out.println((userInfoMapper.getUserInfo(item.getFriend_id())));
            System.out.println(userInfoMapper.getUserInfo(item.getFriend_id()).getName());
            item.setFriend_name(userInfoMapper.getUserInfo(item.getFriend_id()).getName());
        }
        return list;
    }
}
