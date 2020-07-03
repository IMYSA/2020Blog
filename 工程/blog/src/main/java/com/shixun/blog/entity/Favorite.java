package com.shixun.blog.entity;

public class Favorite {
    private int id;
    private int user_id;
    private int article_id;
    private String author_name;

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getId() {
        return id;
    }

    public int getArticle_id() {
        return article_id;
    }
}
