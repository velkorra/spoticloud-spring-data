package com.example.spoticloudspringdata.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
class PlaylistAccessID implements Serializable {
    @Column(name = "user_id")
    private int userId;
    @Column(name = "playlist_id")
    private int playlistId;

    public PlaylistAccessID() {
    }

    public PlaylistAccessID(int userId, int playlistId) {
        this.userId = userId;
        this.playlistId = playlistId;
    }

}
