package com.shixun.blog.controller;

import com.shixun.blog.entity.Follow;
import com.shixun.blog.service.FollowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@ResponseBody
@RestController
@CrossOrigin()
public class FollowController {
    @Resource
    private FollowService followService;

    @RequestMapping(value = "/add_follow", method = RequestMethod.POST)
    public void addFollow(@RequestBody Follow f)    {
        followService.addFollow(f);
    }
    @RequestMapping(value = "/search_follow", method = RequestMethod.POST)
    public Follow searchFollow(@RequestBody Follow f)    {
        return followService.searchFollow(f);
    }

    @RequestMapping(value = "/delete_follow", method = RequestMethod.POST)
    public void deleteFollow(@RequestBody Follow f)    {
        followService.deleteFollow(f);
    }

    @RequestMapping(value = "/get_follows", method = RequestMethod.POST)
    public List<Follow> getFollows(@RequestBody Follow f)    {
        return followService.getFollows(f);
    }
}
