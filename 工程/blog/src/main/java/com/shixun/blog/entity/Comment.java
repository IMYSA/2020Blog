package com.shixun.blog.entity;

public class Comment {
    private int id;
    private String content;
    private String author;
    private String time;
    private int articleId;

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setArticleId(int articleId){this.articleId=articleId;}

    public int getArticleId(){return articleId;}

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTime() {
        return time;
    }
}
