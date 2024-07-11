package com.example.spoticloudspringdata.entities;

import com.example.spoticloudspringdata.entities.compositeId.ReleaseArtistID;
import jakarta.persistence.*;

@Entity
@Table(name = "release_artist")
public class ReleaseArtist {
    private ReleaseArtistID id;

    public ReleaseArtist(ReleaseArtistID id) {
        this.id = id;
    }

    protected ReleaseArtist() {

    }

    @EmbeddedId
    public ReleaseArtistID getId() {
        return id;
    }

    public void setId(ReleaseArtistID id) {
        this.id = id;
    }


}

