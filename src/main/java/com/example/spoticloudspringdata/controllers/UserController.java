package com.example.spoticloudspringdata.controllers;

import com.example.spoticloudspringdata.entities.User;
import com.example.spoticloudspringdata.schemas.UserCreate;
import com.example.spoticloudspringdata.schemas.UserResponse;
import com.example.spoticloudspringdata.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{username}")
    public Set<UserResponse> getUser(@PathVariable String username){
        return userService.getByUsername(username);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserCreate user){
        return userService.createUser(user);
    }
}
