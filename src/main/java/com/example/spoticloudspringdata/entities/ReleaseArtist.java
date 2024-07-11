package com.example.spoticloudspringdata.entities;

import com.example.spoticloudspringdata.entities.compositeId.ReleaseArtistId;
import jakarta.persistence.*;

@Entity
@Table(name = "release_artist")
public class ReleaseArtist {
    private ReleaseArtistId id;

    public ReleaseArtist(ReleaseArtistId id) {
        this.id = id;
    }

    protected ReleaseArtist() {

    }

    @EmbeddedId
    public ReleaseArtistId getId() {
        return id;
    }

    public void setId(ReleaseArtistId id) {
        this.id = id;
    }


}

