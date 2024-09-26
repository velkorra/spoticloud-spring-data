package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.*;
import com.example.spoticloudspringdata.schemas.PlaylistCreateDto;
import com.example.spoticloudspringdata.schemas.PlaylistDto;

import java.util.List;
import java.util.Set;

public interface PlaylistService {
    List<PlaylistDto> getAllPlaylists();

    Set<PlaylistDto> ownPlaylists(int userId);

    void createPlaylist(PlaylistCreateDto playlistCreateDto);

    void addTrackToPlaylist(int playlistId, int trackId);

    void addTrackToPlaylist(Playlist playlist, Track track);

    void addTrackSetToPlaylist(Playlist playlist, List<Track> tracks);

    PlaylistDto createRecommendedPlaylist(int userId);

    Set<PlaylistDto> getUserPlaylists(int userId);

    void makePublic(int playlistId);

    void makePrivate(int playlistId);

    String sharePlaylist(int playlistId);

    Playlist getPlaylistByToken(String token);

    PlaylistDto savePrivatePlaylist(int userId, String token);

    void addPlaylist(int userId, int playlistId);

    Playlist savePlaylist(Playlist playlist);

}
