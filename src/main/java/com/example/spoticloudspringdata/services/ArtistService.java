package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.Artist;
import com.example.spoticloudspringdata.schemas.ArtistDto;

import java.util.List;

public interface ArtistService {
    List<ArtistDto> getAllArtists();

    Artist createArtist(ArtistDto artist);
}
