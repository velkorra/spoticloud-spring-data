package com.example.spoticloudspringdata.services.implementations;

import com.example.spoticloudspringdata.entities.*;
import com.example.spoticloudspringdata.exceptions.*;
import com.example.spoticloudspringdata.repositories.TrackRepository;
import com.example.spoticloudspringdata.repositories.PlaylistRepository;
import com.example.spoticloudspringdata.repositories.PlaylistTokenRepository;
import com.example.spoticloudspringdata.repositories.UserRepository;
import com.example.spoticloudspringdata.schemas.PlaylistCreateDto;
import com.example.spoticloudspringdata.schemas.PlaylistDto;
import com.example.spoticloudspringdata.services.PlaylistService;
import com.example.spoticloudspringdata.services.RecommendationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;
    private final TrackRepository trackRepository;
    private final RecommendationService recommendationService;
    private final PlaylistTokenRepository playlistTokenRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository, UserRepository userRepository, TrackRepository trackRepository, RecommendationService recommendationService, PlaylistTokenRepository playlistTokenRepository) {
        this.playlistRepository = playlistRepository;
        this.userRepository = userRepository;
        this.trackRepository = trackRepository;
        this.recommendationService = recommendationService;
        this.playlistTokenRepository = playlistTokenRepository;
    }

    @Override
    public List<PlaylistDto> getAllPlaylists() {
        return playlistRepository.findAll().stream().map(PlaylistDto::new).collect(Collectors.toList());
    }

    @Override
    public Set<PlaylistDto> ownPlaylists(int userId) {
        return playlistRepository.userCreatedPlaylists(userId).stream().map(PlaylistDto::new).collect(Collectors.toSet());
    }

    @Override
    public void createPlaylist(PlaylistCreateDto playlistCreateDto) {
        User user = userRepository.findById(playlistCreateDto.getOwner()).orElseThrow(
                () -> new UserNotFoundException(playlistCreateDto.getOwner())
        );
        Playlist playlist = new Playlist(playlistCreateDto.getName(),
                playlistCreateDto.isPrivate(),
                playlistCreateDto.getDescription(),
                user);
        playlistRepository.save(playlist);
    }

    @Override
    @Transactional
    public void addTrackToPlaylist(int playlistId, int trackId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(
                () -> new PlaylistNotFoundException(playlistId)
        );
        Track track = trackRepository.findById(trackId).orElseThrow(
                () -> new TrackNotFoundException(trackId)
        );
        addTrackToPlaylist(playlist, track);
    }

    @Override
    @Transactional
    public void addTrackToPlaylist(Playlist playlist, Track track) {
        playlist.addTrack(track);
        playlistRepository.save(playlist);
    }

    @Override
    @Transactional
    public void addTrackSetToPlaylist(Playlist playlist, List<Track> tracks) {
        for (Track track : tracks) {
            playlist.addTrack(track);
        }
    }

    @Override
    @Transactional
    public PlaylistDto createRecommendedPlaylist(int userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
        Playlist playlist = recommendationService.recommendPlaylist(userId);
        playlistRepository.save(playlist);
        return new PlaylistDto(playlist);
    }

    @Override
    public Set<PlaylistDto> getUserPlaylists(int userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
        return user.getUserPlaylists().stream()
                .map(UserPlaylist::getPlaylist)
                .map(PlaylistDto::new).collect(Collectors.toSet());
    }

    @Override
    public void makePublic(int playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(
                () -> new PlaylistNotFoundException(playlistId)
        );
        playlist.setPrivate(false);
        playlistRepository.save(playlist);
    }

    @Override
    public void makePrivate(int playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(
                () -> new PlaylistNotFoundException(playlistId)
        );
        playlist.setPrivate(true);
        playlistRepository.save(playlist);
    }

    @Override
    public String sharePlaylist(int playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(
                () -> new PlaylistNotFoundException(playlistId)
        );
        if (!playlist.isPrivate()) {
            return "playlist is public";
        }
        PlaylistToken playlistToken = new PlaylistToken(playlist);
        playlist.getPlaylistTokens().add(playlistToken);
        playlistRepository.save(playlist);
        return playlistToken.getToken();
    }

    @Override
    public Playlist getPlaylistByToken(String token) {
        PlaylistToken playlistToken = playlistTokenRepository.findByToken(token).orElseThrow(
                () -> new TokenNotFoundException(token)
        );
        return playlistToken.getPlaylist();
    }

    @Override
    public PlaylistDto savePrivatePlaylist(int userId, String token) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
        PlaylistToken playlistToken = playlistTokenRepository.findByToken(token).orElseThrow(
                () -> new TokenNotFoundException(token)
        );
        Playlist playlist = getPlaylistByToken(token);
        user.getAccessedPlaylists().add(new PlaylistAccess(playlist, user));
        userRepository.save(user);
        return new PlaylistDto(playlist);
    }

    @Override
    public void addPlaylist(int userId, int playlistId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(
                () -> new PlaylistNotFoundException(playlistId)
        );
        if (playlist.isPrivate()){
            throw new PlaylistNotFoundException(playlistId);
        }
        if (!user.getUserPlaylists().stream().
                map(UserPlaylist::getPlaylist).collect(Collectors.toSet()).contains(playlist)) {
            user.getUserPlaylists().add(new UserPlaylist(user, playlist));
            playlistRepository.save(playlist);
        }
        else {
            throw new PlaylistAlreadySetException(playlistId, userId);
        }
    }

    @Override
    @Transactional
    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

}
