package com.example.spoticloudspringdata.entities;

import com.example.spoticloudspringdata.entities.compositeId.UserPreferencesId;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_preferences")
public class UserPreferences {
    private UserPreferencesId id;
    private float value;

    public UserPreferences(UserPreferencesId id, float value) {
        this.id = id;
        this.value = value;
    }

    protected UserPreferences() {

    }

    @EmbeddedId
    public UserPreferencesId getId() {
        return id;
    }

    public void setId(UserPreferencesId id) {
        this.id = id;
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
        return Float.compare(value, that.value) == 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}