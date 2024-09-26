package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.Track;
import com.example.spoticloudspringdata.entities.User;
import com.example.spoticloudspringdata.schemas.*;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    UserDto getById(int id);

    Track listen(int user, int track);

    List<TrackDto> getLikedTracks(int userId);

    void likeTrack(int userId, int trackId);

    UserDto getByEmail(String email);

    List<UserDto> getByUsername(String username);

    UserDto createUser(UserCreateDto userDto);

    List<HistoryRecordDto> history(int userId);

    void deleteUser(User user);

    void deleteUserById(int id);
}
