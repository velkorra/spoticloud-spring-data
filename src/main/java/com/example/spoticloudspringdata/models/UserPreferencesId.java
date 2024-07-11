package com.example.spoticloudspringdata.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserPreferencesId implements Serializable {
    @Column(name = "user_id")
    private int userId;
    @Column(name = "playlist_id")
    private int genreId;

    public UserPreferencesId() {
    }

    public UserPreferencesId(int userId, int genreId) {
        this.userId = userId;
        this.genreId = genreId;
    }


}