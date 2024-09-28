package com.example.spoticloudspringdata.controllers;

import com.example.spoticloudspringdata.schemas.*;
import com.example.spoticloudspringdata.services.PlaylistService;
import com.example.spoticloudspringdata.services.RecommendationService;
import com.example.spoticloudspringdata.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RecommendationService recommendationService;
    private final PlaylistService playlistService;

    public UserController(UserService userService, RecommendationService recommendationService, PlaylistService playlistService) {
        this.userService = userService;
        this.recommendationService = recommendationService;
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/listen/{user}/{track}")
    public TrackDto listen(@PathVariable("user") int user, @PathVariable("track") int track) {
        return new TrackDto(userService.listen(user, track));
    }

    @GetMapping("/history/{userId}")
    public List<HistoryRecordDto> getHistory(@PathVariable("userId") int userId) {
        return userService.history(userId);
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserCreateDto user) {
        return userService.createUser(user);
    }

    @PostMapping("like/{userId}/{trackId}")
    public void like(@PathVariable("userId") int userId, @PathVariable("trackId") int trackId) {
        userService.likeTrack(userId, trackId);
    }

    @GetMapping("liked/{userId}")
    public List<TrackDto> getLikedTracks(@PathVariable("userId") int userId) {
        return userService.getLikedTracks(userId);
    }

    @GetMapping("/recommend/{userID}")
    public TrackDto recommendTrack(@PathVariable int userID) {
        return new TrackDto(recommendationService.recommendTrack(userID));
    }

    @GetMapping("/recommended-tracks/{userId}")
    public List<TrackDto> getRecommendedTracks(@PathVariable int userId) {
        return recommendationService.recommendTracks(userId)
                .stream().map(TrackDto::new).toList();
    }

    @GetMapping("/recommended-playlist/{userId}")
    public PlaylistDto getRecommendedPlaylist(@PathVariable int userId) {
        return playlistService.createRecommendedPlaylist(userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteUserById(id);
    }

}
