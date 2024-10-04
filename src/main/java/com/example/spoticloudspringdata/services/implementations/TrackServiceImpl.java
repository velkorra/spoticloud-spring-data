package com.example.spoticloudspringdata.services.implementations;


import com.example.spoticloudspringdata.repositories.TrackRepository;
import com.example.spoticloudspringdata.dto.TrackDto;
import com.example.spoticloudspringdata.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<TrackDto> findAll() {
        return trackRepository.findAll().stream().map(TrackDto::new).toList();
    }
}
