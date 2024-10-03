package com.example.spoticloudspringdata.controllers;

import com.example.spoticloudspringdata.entities.Genre;
import com.example.spoticloudspringdata.dto.GenreDto;
import com.example.spoticloudspringdata.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }


    @GetMapping
    public List<GenreDto> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{name}")
    public Genre getGenre(@PathVariable String name) {
        return genreService.findByName(name);
    }
}
