package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.Genre;
import com.example.spoticloudspringdata.dto.GenreDto;

import java.util.List;

public interface GenreService {
    Genre findByName(String name);

    List<GenreDto> getAllGenres();
}
