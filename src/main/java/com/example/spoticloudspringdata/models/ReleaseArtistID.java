package com.example.spoticloudspringdata.models;

import java.io.Serializable;
import java.util.Objects;

class ReleaseArtistID implements Serializable {

    private int artistId;
    private int releaseId;

    public ReleaseArtistID() {
    }

    public ReleaseArtistID(int artistId, int releaseId) {
        this.artistId = artistId;
        this.releaseId = releaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReleaseArtistID that = (ReleaseArtistID) o;
        return artistId == that.artistId && releaseId == that.releaseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId, releaseId);
    }
}
