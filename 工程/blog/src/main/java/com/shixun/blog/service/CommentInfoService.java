package com.shixun.blog.service;

import com.shixun.blog.entity.Comment;

import java.util.List;

public interface CommentInfoService {
    int PostComment(Comment comment);
    List<Comment> GetComment(int articleId);
    List<Comment> GetComment(String author);
}
