package com.example.spoticloudspringdata.controllers;


import com.example.spoticloudspringdata.dto.ReleaseDto;
import com.example.spoticloudspringdata.dto.ReleaseWithTracksDto;
import com.example.spoticloudspringdata.dto.TrackDto;
import com.example.spoticloudspringdata.services.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/releases")
public class ReleaseController {
    private final ReleaseService releaseService;

    @Autowired
    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping
    public List<ReleaseDto> getAllReleases() {
        return releaseService.getAllReleases();
    }

    @GetMapping("/with_tracks")
    public List<ReleaseWithTracksDto> getAllReleasesWithTracks() {
        return releaseService.getAllReleasesWithTracks();
    }

    @GetMapping("/tracks/{releaseId}")
    public List<TrackDto> getReleaseTracks(@PathVariable int releaseId) {
        return releaseService.getAllTracks(releaseId);
    }
}
