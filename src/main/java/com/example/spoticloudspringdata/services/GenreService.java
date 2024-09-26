package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.Genre;
import com.example.spoticloudspringdata.exceptions.GenreNotFoundException;
import com.example.spoticloudspringdata.schemas.GenreDto;

import java.util.List;

public interface GenreService {
    Genre findByName(String name);

    List<GenreDto> getAllGenres();
}
