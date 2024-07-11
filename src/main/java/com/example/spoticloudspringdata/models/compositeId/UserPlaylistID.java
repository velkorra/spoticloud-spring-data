package com.example.spoticloudspringdata.models.compositeId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserPlaylistID implements Serializable {
    @Column(name = "user_id")
    private int userId;
    @Column(name = "playlist_id")
    private int playlistId;

    public UserPlaylistID() {}

    public UserPlaylistID(int userId, int playlistId) {
        this.userId = userId;
        this.playlistId = playlistId;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPlaylistID that = (UserPlaylistID) o;
        return userId == that.userId && playlistId == that.playlistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, playlistId);
    }
}