package com.shixun.blog.entity;

public class Article {
    private int id;
    private String title;
    private String author;
    private String time;
    private String tag;
    private String description;
    private String file;
    private String content_md;
    private String content_html;
    private String author_name;
    private boolean isAudit;

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public boolean isAudit() {
        return isAudit;
    }

    public void setAudit(boolean audit) {
        isAudit = audit;
    }

    public String getContent_html() {
        return content_html;
    }

    public String getContent_md() {
        return content_md;
    }

    public void setContent_html(String content_html) {
        this.content_html = content_html;
    }

    public void setContent_md(String content_md) {
        this.content_md = content_md;
    }
}
