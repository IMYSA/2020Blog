package com.shixun.blog.service;

import com.shixun.blog.entity.Comment;

public interface CommentInfoService {
    int PostComment(Comment comment);
    Comment GetComment(int articleId);
    Comment GetComment(String author);
}
