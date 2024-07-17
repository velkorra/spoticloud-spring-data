package com.example.spoticloudspringdata.repositories.implementations;


import com.example.spoticloudspringdata.entities.PlaylistToken;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PlaylistTokenRepository extends AbstractBaseRepository<PlaylistToken, Integer> {
    private final PlaylistTokenJpaRepository repository;


    public PlaylistTokenRepository(JpaRepository<PlaylistToken, Integer> repository) {
        super(repository);
        this.repository = (PlaylistTokenJpaRepository) repository;
    }

    public Optional<PlaylistToken> findByToken(String token) {
        return repository.findByToken(token);
    }
}


interface PlaylistTokenJpaRepository extends JpaRepository<PlaylistToken, Integer> {
    Optional<PlaylistToken> findByToken(String token);
}