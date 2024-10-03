package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.dto.ReleaseDto;
import com.example.spoticloudspringdata.dto.ReleaseWithTracksDto;
import com.example.spoticloudspringdata.dto.TrackDto;

import java.util.List;

public interface ReleaseService {
    List<ReleaseDto> getAllReleases();

    List<ReleaseWithTracksDto> getAllReleasesWithTracks();

    List<TrackDto> getAllTracks(Integer releaseId);
}
