package com.example.spoticloudspringdata.models.compositeId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReleaseArtistID implements Serializable {
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

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
