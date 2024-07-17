package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.Track;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public class TrackRepository extends AbstractBaseRepository<Track, Integer> {
    private final TrackJpaRepository repository;

    public TrackRepository(JpaRepository<Track, Integer> repository) {
        super(repository);
        this.repository = (TrackJpaRepository) repository;
    }
}


@Repository
interface TrackJpaRepository extends JpaRepository<Track, Integer> {
}
