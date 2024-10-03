package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.dto.TrackDto;

import java.util.List;

public interface TrackService {
    List<TrackDto> findAll();
}
