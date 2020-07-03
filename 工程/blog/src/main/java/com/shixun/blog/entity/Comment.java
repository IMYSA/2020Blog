package com.shixun.blog.entity;

public class Comment {
    private int id;
    private String content;
    private int  author_id;
    private String time;
    private int article_id;
    private String author_name;

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setArticle_id(int article_id){this.article_id = article_id;}

    public int getArticle_id(){return article_id;}

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public String getTime() {
        return time;
    }
}
