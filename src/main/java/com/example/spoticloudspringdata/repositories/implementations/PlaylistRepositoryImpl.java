package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.Playlist;
import com.example.spoticloudspringdata.repositories.PlaylistRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class PlaylistRepositoryImpl implements PlaylistRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public PlaylistRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Playlist save(Playlist playlist) {
        return entityManager.merge(playlist);
    }

    @Override
    public Optional<Playlist> findById(int id) {
        return Optional.ofNullable(entityManager.find(Playlist.class, id));
    }

    @Override
    public Set<Playlist> findAll() {
        return Set.copyOf(entityManager.createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList());
    }

    @Override
    public Set<Playlist> userCreatedPlaylists(int userId) {
        return Set.copyOf(entityManager.createQuery("SELECT p FROM Playlist p WHERE p.owner.id = :userId", Playlist.class)
                .setParameter("userId", userId)
                .getResultList());
    }

}
