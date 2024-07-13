package com.example.spoticloudspringdata.repositories;

import com.example.spoticloudspringdata.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

    @Query("select g from Genre g where g.name = :name")
    Genre findByName(@Param("name") String name);

    @Query("SELECT g FROM Genre g WHERE g.parentGenre IS NULL")
    List<Genre> findMainGenres();
}
