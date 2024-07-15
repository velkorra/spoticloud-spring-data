package com.example.spoticloudspringdata.repositories;

import com.example.spoticloudspringdata.entities.Release;
import com.example.spoticloudspringdata.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleaseJpaRepository extends JpaRepository<Release, Integer> {

    @Query("select t from Track t where t.release = :release")
    List<Track> findAllTracks(Release release);
}
