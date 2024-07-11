package com.example.spoticloudspringdata.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "playlist_access")
@IdClass(PlaylistAccessID.class)
public class PlaylistAccess {

    private int userId;
    private int playlistId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "playlist_id")
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
        PlaylistAccess that = (PlaylistAccess) o;
        return userId == that.userId && playlistId == that.playlistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, playlistId);
    }
}

