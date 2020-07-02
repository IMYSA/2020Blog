package com.shixun.blog.service;

import com.shixun.blog.entity.Comment;

import java.util.List;

public interface CommentInfoService {
    int PostComment(Comment comment);
    List<Comment> GetCommentByArticle(int articleId);
    List<Comment> GetCommentByAuthor(String author);
}
