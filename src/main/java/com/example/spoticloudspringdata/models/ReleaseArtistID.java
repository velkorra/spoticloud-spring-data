package com.example.spoticloudspringdata.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
class ReleaseArtistID implements Serializable {
    @Column(name = "user_id")
    private int artistId;
    @Column(name = "release_id")
    private int releaseId;

    public ReleaseArtistID() {
    }

    public ReleaseArtistID(int artistId, int releaseId) {
        this.artistId = artistId;
        this.releaseId = releaseId;
    }

}
