package com.example.spoticloudspringdata.services.implementations;

import com.example.spoticloudspringdata.entities.Genre;
import com.example.spoticloudspringdata.exceptions.GenreNotFoundException;
import com.example.spoticloudspringdata.repositories.GenreRepository;
import com.example.spoticloudspringdata.dto.GenreDto;
import com.example.spoticloudspringdata.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name).orElseThrow(
                () -> new GenreNotFoundException(name)
        );
    }

    @Override
    public List<GenreDto> getAllGenres() {
        return genreRepository.findAll().stream().map(GenreDto::new).toList();
    }
}
