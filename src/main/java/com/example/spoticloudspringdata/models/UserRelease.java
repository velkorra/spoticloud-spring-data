package com.example.spoticloudspringdata.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_release")
@IdClass(UserReleaseID.class)
public class UserRelease {
    private int userId;
    private int releaseId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Id
    @Column(name = "release_id")
    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    @Basic
    @Column(name = "date_added")
    private Timestamp dateAdded;

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRelease that = (UserRelease) o;
        return userId == that.userId && releaseId == that.releaseId && Objects.equals(dateAdded, that.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, releaseId, dateAdded);
    }
}
