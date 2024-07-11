package com.example.spoticloudspringdata.models;

import com.example.spoticloudspringdata.models.compositeId.ReleaseArtistID;
import jakarta.persistence.*;

import java.util.Objects;

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

