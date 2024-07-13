package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.User;
import com.example.spoticloudspringdata.repositories.implementations.UserRepository;
import com.example.spoticloudspringdata.schemas.UserCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public User createUser(UserCreate user) {
        User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
        return userRepository.save(newUser);
    }
}
