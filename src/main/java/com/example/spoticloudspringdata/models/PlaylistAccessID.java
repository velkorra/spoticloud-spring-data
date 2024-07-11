package com.example.spoticloudspringdata.models;

import java.io.Serializable;
import java.util.Objects;

class PlaylistAccessID implements Serializable {

    private int userId;
    private int playlistId;

    public PlaylistAccessID() {
    }

    public PlaylistAccessID(int userId, int playlistId) {
        this.userId = userId;
        this.playlistId = playlistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistAccessID that = (PlaylistAccessID) o;
        return userId == that.userId && playlistId == that.playlistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, playlistId);
    }
}
