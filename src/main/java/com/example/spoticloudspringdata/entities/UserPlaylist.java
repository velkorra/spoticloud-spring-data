package com.example.spoticloudspringdata.entities;

import com.example.spoticloudspringdata.entities.compositeId.UserPlaylistId;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_playlist")
public class UserPlaylist {
    private UserPlaylistId id;
    private Timestamp dateAdded;


    public UserPlaylist(UserPlaylistId id) {
        this.id = id;
    }

    protected UserPlaylist() {

    }

    @EmbeddedId
    public UserPlaylistId getId() {
        return id;
    }
    public void setId(UserPlaylistId id) {
        this.id = id;
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
        return Objects.equals(id, that.id) && Objects.equals(dateAdded, that.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateAdded);
    }
}