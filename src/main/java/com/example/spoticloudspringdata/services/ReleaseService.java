package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.schemas.ReleaseDto;
import com.example.spoticloudspringdata.schemas.ReleaseWithTracksDto;
import com.example.spoticloudspringdata.schemas.TrackDto;

import java.util.List;

public interface ReleaseService {
    List<ReleaseDto> getAllReleases();

    List<ReleaseWithTracksDto> getAllReleasesWithTracks();

    List<TrackDto> getAllTracks(Integer releaseId);
}
