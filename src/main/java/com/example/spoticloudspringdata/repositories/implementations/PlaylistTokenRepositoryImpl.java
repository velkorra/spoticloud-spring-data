package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.PlaylistToken;
import com.example.spoticloudspringdata.repositories.PlaylistTokenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PlaylistTokenRepositoryImpl implements PlaylistTokenRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public PlaylistTokenRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public PlaylistToken save(PlaylistToken playlistToken) {
        return entityManager.merge(playlistToken);
    }

    @Override
    public Optional<PlaylistToken> findByToken(String token) {
        try {
            PlaylistToken playlistToken = entityManager.createQuery("select pt from PlaylistToken pt where pt.token = :token", PlaylistToken.class)
                    .setParameter("token", token)
                    .getSingleResult();
            return Optional.of(playlistToken);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
