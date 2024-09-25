package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.Release;
import com.example.spoticloudspringdata.entities.Track;
import com.example.spoticloudspringdata.repositories.ReleaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReleaseRepositoryImpl implements ReleaseRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public ReleaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Release save(Release release) {
        entityManager.merge(release);
        return release;
    }

    @Override
    public Optional<Release> findById(int id) {
        return Optional.ofNullable(entityManager.find(Release.class, id));
    }

    @Override
    public List<Release> findAll() {
        return entityManager.createQuery("SELECT r FROM Release r", Release.class).getResultList();
    }

    @Override
    public List<Track> findAllTracks(Release release) {
        return entityManager.createQuery("SELECT t FROM Track t WHERE t.release = :release", Track.class)
                .setParameter("release", release)
                .getResultList();
    }

}
