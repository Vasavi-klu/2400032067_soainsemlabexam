package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(
            @PathVariable String username) {

        return userService.getUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/id/{userid}")
    public ResponseEntity<User> getUserById(
            @PathVariable Long userid) {

        return userService.getUserById(userid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}