package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.Artist;
import com.example.spoticloudspringdata.repositories.ArtistRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ArtistRepositoryImpl implements ArtistRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public ArtistRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Artist save(Artist artist) {
        return entityManager.merge(artist);
    }

    @Override
    public Optional<Artist> findById(int id) {
        return Optional.ofNullable(entityManager.find(Artist.class, id));
    }

    @Override
    public List<Artist> findAll() {
        return entityManager.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
    }

    @Override
    public List<Artist> findByName(String name) {
        return entityManager.createQuery("SELECT a FROM Artist a WHERE a.name = :name", Artist.class)
                .setParameter("name", name)
                .getResultList();
    }


}
