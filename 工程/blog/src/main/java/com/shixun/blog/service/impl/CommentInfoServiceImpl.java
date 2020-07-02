package com.shixun.blog.service.impl;

import com.shixun.blog.entity.Comment;
import com.shixun.blog.mapper.CommentInfoMapper;
import com.shixun.blog.mapper.CommentInfoMapper;
import com.shixun.blog.service.CommentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

public class CommentInfoServiceImpl implements CommentInfoService{
    @Resource
    private CommentInfoMapper commentInfoMapper;

    @Override
    public int PostComment(Comment comment){
        commentInfoMapper.AddComment(comment);
        return 1;
    }

    @Override
    public List<Comment> GetCommentByArticle(int articleId) {
        return commentInfoMapper.GetCommentByArticle(articleId);
    }

    @Override
    public List<Comment> GetCommentByAuthor(String author) {
        return commentInfoMapper.GetCommentByAuthor(author);
    }
}
