package com.shixun.blog.entity;

public class User {
    private int id;
    private String name;
    private String password;
    private String avatar;
    private String description;
    private boolean is_admin;

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

    public boolean isIs_admin() {
        return is_admin;
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

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
