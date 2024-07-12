package com.example.spoticloudspringdata.entities;

import com.example.spoticloudspringdata.entities.compositeId.TrackPlaylistId;
import jakarta.persistence.*;

@Entity
public class TrackPlaylist {
    private TrackPlaylistId id;
    private Track track;
    private Playlist playlist;

    public TrackPlaylist(TrackPlaylistId id, Track track, Playlist playlist) {
        this.id = id;
        this.track = track;
        this.playlist = playlist;
    }

    protected TrackPlaylist() {

    }

    @EmbeddedId
    public TrackPlaylistId getId() {
        return id;
    }

    public void setId(TrackPlaylistId id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn(name = "track_id", referencedColumnName = "id")
    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn(name = "track_id", referencedColumnName = "id")
    public Playlist getPlaylist() {
        return playlist;
    }


    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }


}
