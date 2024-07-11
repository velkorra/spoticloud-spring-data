package com.example.spoticloudspringdata.models;

import java.io.Serializable;
import java.util.Objects;

public class UserPlaylistID implements Serializable {

    private int userId;
    private int playlistId;

    public UserPlaylistID() {}

    public UserPlaylistID(int userId, int playlistId) {
        this.userId = userId;
        this.playlistId = playlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
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