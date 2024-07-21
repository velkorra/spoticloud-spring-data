package com.example.spoticloudspringdata.repositories;


import com.example.spoticloudspringdata.entities.Artist;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository{
    Artist save(Artist artist);
    Optional<Artist> findById(int id);
    List<Artist> findAll();
    List<Artist> findByName(String name);

}


