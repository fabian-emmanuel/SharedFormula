package com.sharedformula.user.controller;

import com.sharedformula.user.model.User;
import com.sharedformula.user.payload.*;
import com.sharedformula.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basepath-user}")
public class UserController {
    private final UserService service;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return service.registerUser(userRequest);
    }

    @GetMapping("/{userId}/details")
    public UserDetailsResponse getUserDetails(@PathVariable Long userId) {
        return service.getUserDetails(userId);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
            return service.getUser(userId);
    }

    @PostMapping("/{creatorId}/create-content")
    public boolean createContent(@PathVariable Long creatorId, @RequestBody ContentRequest request) {
        return service.createContent(creatorId, request);
    }

    @PostMapping("/{contractorId}/sell-content")
    public boolean sellContent(@PathVariable Long contractorId, @RequestBody SaleRequest request) {
        return service.sellContent(contractorId, request);
    }

}
