package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.Genre;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepository extends AbstractBaseRepository<Genre, Integer> {
    private final GenreJpaRepository repository;

    public GenreRepository(JpaRepository<Genre, Integer> repository) {
        super(repository);
        this.repository = (GenreJpaRepository) repository;
    }
    public Genre findByName(String name) {
        return repository.findByName(name);
    }
    public List<Genre> findMainGenres(){
        return repository.findMainGenres();
    }


}


@Repository
interface GenreJpaRepository extends JpaRepository<Genre, Integer> {

    @Query("select g from Genre g where g.name = :name")
    Genre findByName(@Param("name") String name);

    @Query("SELECT g FROM Genre g WHERE g.parentGenre IS NULL")
    List<Genre> findMainGenres();
}
