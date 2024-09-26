package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.*;

import java.util.*;

public interface RecommendationService {
    void adjustPreferences(User user, Track track, float value);

    Track recommendTrack(int userId);

    Track recommendTrack(User user);

    Playlist recommendPlaylist(int userId);

    List<Track> recommendTracks(int userId);

    List<Track> recommendTracks(User user);
}
