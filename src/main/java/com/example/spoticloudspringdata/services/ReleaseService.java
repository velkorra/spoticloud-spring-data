package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.Release;
import com.example.spoticloudspringdata.entities.Track;
import com.example.spoticloudspringdata.repositories.ReleaseJpaRepository;
import com.example.spoticloudspringdata.schemas.ReleaseResponse;
import com.example.spoticloudspringdata.schemas.ReleaseWithTracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseService {
    private final ReleaseJpaRepository releaseJpaRepository;

    @Autowired
    public ReleaseService(ReleaseJpaRepository releaseJpaRepository) {
        this.releaseJpaRepository = releaseJpaRepository;
    }
    public List<ReleaseResponse> getAllReleases() {
        return releaseJpaRepository.findAll().stream().map(ReleaseResponse::new).toList();
    }

    public List<ReleaseWithTracks> getAllReleasesWithTracks() {
        return releaseJpaRepository.findAll().stream().map(ReleaseWithTracks::new).toList();
    }
    public List<Track> getAllTracks(Integer releaseId) {
        Release release = releaseJpaRepository.findById(releaseId).orElseThrow(
                () -> new RuntimeException("Could not find release with id: " + releaseId)
        );
        return releaseJpaRepository.findAllTracks(release);
    }
}
