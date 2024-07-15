package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.User;
import com.example.spoticloudspringdata.repositories.implementations.UserRepository;
import com.example.spoticloudspringdata.schemas.UserCreate;
import com.example.spoticloudspringdata.schemas.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(UserResponse::new).toList();
    }

    public UserResponse getById(int id) {
        return userRepository.findById(id).map(UserResponse::new).orElse(null);
    }

    public Set<UserResponse> getByUsername(String username) {
        return userRepository.findByUsername(username).stream().map(UserResponse::new).collect(Collectors.toSet());
    }


    public UserResponse getByEmail(String email) {
        return userRepository.findByEmail(email).map(UserResponse::new).orElse(null);
    }


    public UserResponse createUser(UserCreate user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
            return new UserResponse(userRepository.save(newUser));
        }
        throw new IllegalArgumentException("Email already exists");
    }


    public void deleteUser(User user) {
        user.setDeleted(true);
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        user.setDeleted(true);
        userRepository.save(user);
    }
}
