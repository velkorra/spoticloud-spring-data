package com.example.spoticloudspringdata.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserReleaseID implements Serializable {
    @Column(name = "user_id")
    private int userId;
    @Column(name = "release_id")
    private int releaseId;

    public UserReleaseID() {
    }

    public UserReleaseID(int userId, int releaseId) {
        this.userId = userId;
        this.releaseId = releaseId;
    }

}