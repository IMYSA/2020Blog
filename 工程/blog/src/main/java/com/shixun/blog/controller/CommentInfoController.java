package com.shixun.blog.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shixun.blog.entity.Comment;
import com.shixun.blog.mapper.CommentInfoMapper;
import com.shixun.blog.service.CommentInfoService;
import com.shixun.blog.service.impl.UserInfoServiceImpl;
import com.sun.net.httpserver.Authenticator;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@ResponseBody
@RestController
@CrossOrigin()
public class CommentInfoController {
    @Resource
    private CommentInfoMapper commentInfoMapper;
    @Resource
    private CommentInfoService commentInfoService;
    @RequestMapping(value = "/add_comment", method = RequestMethod.POST)
    public int PostComment(@RequestBody Comment comment){
        return commentInfoService.PostComment(comment);
    }

    @RequestMapping(value = "/get_comments", method = RequestMethod.POST)
    public List<Comment> getComments(@RequestBody Comment comment){
        return commentInfoService.GetComments(comment.getArticle_id());
    }
}
