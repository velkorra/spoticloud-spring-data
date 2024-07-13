package com.example.spoticloudspringdata.repositories;

import com.example.spoticloudspringdata.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Query("SELECT g FROM Genre g LEFT JOIN FETCH g.parentGenre")
    List<Genre> findAllGenresWithParents();

    @Query("SELECT g FROM Genre g WHERE g.parentGenre IS NULL")
    List<Genre> findMainGenres();
}