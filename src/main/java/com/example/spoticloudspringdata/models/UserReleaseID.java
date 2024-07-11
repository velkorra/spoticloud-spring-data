package com.example.spoticloudspringdata.models;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.Objects;

public class UserReleaseID implements Serializable {
    private int userId;
    private int releaseId;

    public UserReleaseID() {}

    public UserReleaseID(int userId, int releaseId) {
        this.userId = userId;
        this.releaseId = releaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserReleaseID that = (UserReleaseID) o;
        return userId == that.userId && releaseId == that.releaseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, releaseId);
    }
}