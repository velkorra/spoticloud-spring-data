package com.example.spoticloudspringdata.models;

import com.example.spoticloudspringdata.models.compositeId.UserPlaylistID;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_playlist")
@IdClass(UserPlaylistID.class)
public class UserPlaylist {

    private int userId;
    private int playlistId;
    private Timestamp dateAdded;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "playlist_id", nullable = false)
    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    @Column(name = "date_added", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
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
        UserPlaylist that = (UserPlaylist) o;
        return userId == that.userId && playlistId == that.playlistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, playlistId);
    }
}