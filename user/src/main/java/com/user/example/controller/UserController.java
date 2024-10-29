package com.user.example.controller;

import com.user.example.dto.ClientRequest;
import com.user.example.dto.ClientResponse;
import com.user.example.entity.User;
import com.user.example.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

      private final UserService userService;

    @PostMapping("/register")
    public ClientResponse register(@RequestBody @Valid ClientRequest request) {
        return userService.register(request);
    }
    @GetMapping("/{id}")
    public User getUserDetails(@PathVariable Long id) {
        User user = userService.getUserDetails(id);
        return user;
    }
}
