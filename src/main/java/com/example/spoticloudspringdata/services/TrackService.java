package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.schemas.TrackDto;

import java.util.List;

public interface TrackService {
    List<TrackDto> findAll();
}
