package com.example.spoticloudspringdata.models;
import java.io.Serializable;
import java.util.Objects;

public class UserPreferencesId implements Serializable {

    private int userId;
    private int genreId;

    public UserPreferencesId() {}

    public UserPreferencesId(int userId, int genreId) {
        this.userId = userId;
        this.genreId = genreId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPreferencesId that = (UserPreferencesId) o;
        return userId == that.userId && genreId == that.genreId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, genreId);
    }
}