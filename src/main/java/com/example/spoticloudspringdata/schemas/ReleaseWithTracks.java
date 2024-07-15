package com.example.spoticloudspringdata.schemas;

import com.example.spoticloudspringdata.entities.Release;


import java.util.List;
import java.util.Set;

public class ReleaseWithTracks extends ReleaseResponse{

    private List<TrackResponse> tracks;

    public ReleaseWithTracks(Release release) {
        super(release);
        this.tracks = release.getTracks().stream().map(TrackResponse::new).toList();
    }

    public List<TrackResponse> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackResponse> tracks) {
        this.tracks = tracks;
    }
}
