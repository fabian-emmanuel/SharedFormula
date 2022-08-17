package com.sharedformula.content.controller;

import com.sharedformula.content.apiresponse.ApiDataResponse;
import com.sharedformula.content.model.Content;
import com.sharedformula.content.payload.ContentDto;
import com.sharedformula.content.payload.ContentRequest;
import com.sharedformula.content.service.ContentService;
import com.sharedformula.content.util.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basepath-content}")
public class ContentController {
    private final ContentService service;

    @PostMapping("/{userId}")
    public ResponseEntity<ApiDataResponse<Long>> createContent(@PathVariable Long userId, @RequestBody ContentRequest contentRequest) {
        return ApiResponseUtil.response(HttpStatus.CREATED,this.service.createContent(userId, contentRequest), "Content created successfully");
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ApiDataResponse<ContentDto>>  getContent(@PathVariable Long contentId) {
        return ApiResponseUtil.response(HttpStatus.OK, this.service.getContent(contentId), "Content retrieved successfully");
    }

}
