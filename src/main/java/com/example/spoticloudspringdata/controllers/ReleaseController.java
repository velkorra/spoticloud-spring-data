package com.example.spoticloudspringdata.controllers;


import com.example.spoticloudspringdata.entities.Release;
import com.example.spoticloudspringdata.schemas.ReleaseResponse;
import com.example.spoticloudspringdata.schemas.ReleaseWithTracks;
import com.example.spoticloudspringdata.services.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<ReleaseResponse> getAllReleases() {
        return releaseService.getAllReleases();
    }

    @GetMapping("/with_tracks")
    public List<ReleaseWithTracks> getAllReleasesWithTracks() {
        return releaseService.getAllReleasesWithTracks();
    }
}
