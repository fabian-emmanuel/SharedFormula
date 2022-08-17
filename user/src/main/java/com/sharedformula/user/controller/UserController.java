package com.sharedformula.user.controller;

import com.sharedformula.user.apiresponse.ApiDataResponse;
import com.sharedformula.user.model.User;
import com.sharedformula.user.payload.*;
import com.sharedformula.user.service.UserService;
import com.sharedformula.user.util.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basepath-user}")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<ApiDataResponse<UserResponse>>  createUser(@RequestBody UserRequest userRequest) {
        return ApiResponseUtil.response(HttpStatus.CREATED, service.registerUser(userRequest), "User created successfully");
    }

    @GetMapping("/{userId}/details")
    public ResponseEntity<ApiDataResponse<UserDetailsResponse>> getUserDetails(@PathVariable Long userId) {
        return ApiResponseUtil.response(HttpStatus.OK, service.getUserDetails(userId), "User details retrieved successfully");
    }

    @PostMapping("/{creatorId}/create-content")
    public ResponseEntity<ApiDataResponse<Boolean>> createContent(@PathVariable Long creatorId, @RequestBody ContentRequest request) {
        return ApiResponseUtil.response(HttpStatus.OK, service.createContent(creatorId, request), "Content created successfully");
    }

    @PostMapping("/{contractorId}/sell-content")
    public ResponseEntity<ApiDataResponse<Boolean>> sellContent(@PathVariable Long contractorId, @RequestBody SaleRequest request) {
        return ApiResponseUtil.response(HttpStatus.OK, service.sellContent(contractorId, request), "Content sold successfully");
    }

}
