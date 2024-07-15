package com.example.spoticloudspringdata.schemas;

import com.example.spoticloudspringdata.entities.User;

public class UserResponse {
    private int id;
    private String username;
    private String email;

    public UserResponse(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
