package com.example.spoticloudspringdata.models;

import com.example.spoticloudspringdata.models.UserPreferencesId;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_preferences")
@IdClass(UserPreferencesId.class)
public class UserPreferences {

    private int userId;
    private int genreId;
    private float value;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "genre_id")
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Column(name = "value", nullable = false, columnDefinition = "real DEFAULT 0")
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPreferences that = (UserPreferences) o;
        return userId == that.userId && genreId == that.genreId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, genreId);
    }
}