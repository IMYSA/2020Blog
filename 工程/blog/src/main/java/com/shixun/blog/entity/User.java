package com.shixun.blog.entity;

public class User {
    private int id;
    private String name;
    private String password;
    private String avatar;
    private String description;
    private boolean isManager;

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDescription() {
        return description;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
}
