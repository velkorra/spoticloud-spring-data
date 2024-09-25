package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.Genre;
import com.example.spoticloudspringdata.repositories.GenreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GenreRepositoryImpl implements GenreRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public GenreRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Genre save(Genre genre) {
        return entityManager.merge(genre);
    }

    @Override
    public Optional<Genre> findById(int id) {
        return Optional.ofNullable(entityManager.find(Genre.class, id));
    }

    @Override
    public List<Genre> findAll() {
        return entityManager.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
    }

    @Override
    public Optional<Genre> findByName(String name) {
        try {
            Genre genre = entityManager.createQuery("SELECT g FROM Genre g WHERE g.name = :name", Genre.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return Optional.of(genre);
        }
        catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public List<Genre> findMainGenres() {
        return entityManager.createQuery("SELECT g FROM Genre g WHERE g.parentGenre IS NULL", Genre.class).getResultList();
    }


}
