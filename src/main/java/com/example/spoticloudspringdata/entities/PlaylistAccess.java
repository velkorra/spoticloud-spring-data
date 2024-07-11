package com.example.spoticloudspringdata.entities;

import com.example.spoticloudspringdata.entities.compositeId.PlaylistAccessID;
import jakarta.persistence.*;

@Entity
@Table(name = "playlist_access")
public class PlaylistAccess {
    private PlaylistAccessID id;

    public PlaylistAccess(PlaylistAccessID id) {
        this.id = id;
    }

    protected PlaylistAccess() {

    }

    @EmbeddedId
    public PlaylistAccessID getId() {
        return id;
    }

    public void setId(PlaylistAccessID id) {
        this.id = id;
    }
}

