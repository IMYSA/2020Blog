package com.shixun.blog.service;

import com.shixun.blog.entity.Comment;

import java.util.List;

public interface CommentInfoService {

    int PostComment(Comment comment);
    List<Comment> GetCommentById(int articleId);
    List<Comment> GetComments(int  author_id);
}
