package com.venkatesh.springSecurity.controller;

import com.venkatesh.springSecurity.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
public interface UserApi {

    @GetMapping("/")
    @PreAuthorize("hasAuthority('admin')")
    public List<User> getUsers();

    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody User user);

    @GetMapping("/login/{userId}")
    @PreAuthorize("hasAuthority('user')")
    public User getUserById(@PathVariable("userId") Long userId);
}
