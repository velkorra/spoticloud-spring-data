package com.example.spoticloudspringdata.models;

import com.example.spoticloudspringdata.models.compositeId.PlaylistAccessID;
import jakarta.persistence.*;

import java.util.Objects;

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

