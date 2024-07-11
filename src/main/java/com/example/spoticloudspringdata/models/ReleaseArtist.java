package com.example.spoticloudspringdata.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "release_artist")
@IdClass(ReleaseArtistID.class)
public class ReleaseArtist {

    private int artistId;
    private int releaseId;

    @Id
    @Column(name = "artist_id")
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Id
    @Column(name = "release_id")
    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReleaseArtist that = (ReleaseArtist) o;
        return artistId == that.artistId && releaseId == that.releaseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId, releaseId);
    }
}

