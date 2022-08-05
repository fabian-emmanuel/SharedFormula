package com.sharedformula.content.controller;

import com.sharedformula.content.model.Content;
import com.sharedformula.content.payload.ContentRequest;
import com.sharedformula.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basepath-content}")
public class ContentController {
    private final ContentService service;

    @PostMapping("/{userId}")
    public Long createContent(@PathVariable Long userId, @RequestBody ContentRequest contentRequest) {
        return this.service.createContent(userId, contentRequest);
    }

    @GetMapping("/{contentId}")
    public Content getContent(@PathVariable Long contentId) {
        return this.service.getContent(contentId);
    }

}
