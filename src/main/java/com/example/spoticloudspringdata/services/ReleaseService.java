package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.Release;
import com.example.spoticloudspringdata.entities.Track;
import com.example.spoticloudspringdata.exceptions.ReleaseNotFoundException;
import com.example.spoticloudspringdata.schemas.ReleaseDto;
import com.example.spoticloudspringdata.schemas.ReleaseWithTracksDto;
import com.example.spoticloudspringdata.schemas.TrackDto;

import java.util.Comparator;
import java.util.List;

public interface ReleaseService {
    List<ReleaseDto> getAllReleases();

    List<ReleaseWithTracksDto> getAllReleasesWithTracks();

    List<TrackDto> getAllTracks(Integer releaseId);
}
