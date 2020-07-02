package com.shixun.blog.entity;

public class Follow {
    private int id;
    private int user_id;
    private int friend_id;
    private String friend_name;

    public void setId(int id) {
        this.id = id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getFriend_name() {
        return friend_name;
    }
}
