package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.Playlist;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class PlaylistRepository extends AbstractBaseRepository<Playlist, Integer> {
    private final PlaylistJpaRepository repository;

    public PlaylistRepository(JpaRepository<Playlist, Integer> repository) {
        super(repository);
        this.repository = (PlaylistJpaRepository) repository;
    }

    public Set<Playlist> userCreatedPlaylists(int id) {
        return repository.findByOwnerId(id);
    }

}


interface PlaylistJpaRepository extends JpaRepository<Playlist, Integer> {

    @Query("select p from Playlist p where p.owner.id = :id")
    Set<Playlist> findByOwnerId(@Param("id") Integer id);

}
