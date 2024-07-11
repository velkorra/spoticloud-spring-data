package com.example.spoticloudspringdata.entities;

import com.example.spoticloudspringdata.entities.compositeId.PlaylistAccessId;
import jakarta.persistence.*;

@Entity
@Table(name = "playlist_access")
public class PlaylistAccess {
    private PlaylistAccessId id;

    public PlaylistAccess(PlaylistAccessId id) {
        this.id = id;
    }

    protected PlaylistAccess() {

    }

    @EmbeddedId
    public PlaylistAccessId getId() {
        return id;
    }

    public void setId(PlaylistAccessId id) {
        this.id = id;
    }
}

