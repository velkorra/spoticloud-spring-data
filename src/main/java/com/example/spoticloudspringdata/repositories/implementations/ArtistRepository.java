package com.example.spoticloudspringdata.repositories.implementations;


import com.example.spoticloudspringdata.entities.Artist;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepository extends AbstractBaseRepository<Artist, Integer> {
    private final ArtistJpaRepository repository;

    public ArtistRepository(JpaRepository<Artist, Integer> repository) {
        super(repository);
        this.repository = (ArtistJpaRepository) repository;
    }

    public List<Artist> findByName(String name) {
        return repository.findByName(name);
    }


}


interface ArtistJpaRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findByName(String name);
}
