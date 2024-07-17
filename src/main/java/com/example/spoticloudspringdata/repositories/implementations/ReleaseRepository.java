package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.Release;
import com.example.spoticloudspringdata.entities.Track;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReleaseRepository extends AbstractBaseRepository<Release, Integer>{
    private final ReleaseJpaRepository repository;

    @Autowired
    public ReleaseRepository(JpaRepository<Release, Integer> repository) {
        super(repository);
        this.repository = (ReleaseJpaRepository) repository;
    }

    public List<Track> findAllTracks(Release release){
        return repository.findAllTracks(release);
    }
}




@Repository
interface ReleaseJpaRepository extends JpaRepository<Release, Integer> {

    @Query("select t from Track t where t.release = :release")
    List<Track> findAllTracks(Release release);
}
