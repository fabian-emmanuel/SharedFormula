package com.sharedformula.content.service;

import com.sharedformula.content.exception.ResourceNotFoundException;
import com.sharedformula.content.model.Content;
import com.sharedformula.content.payload.ContentRequest;
import com.sharedformula.content.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository repository;

    @Override
    public Long createContent(Long userId, ContentRequest request) {
        Content content = Content.builder()
                .name(request.getName())
                .price(request.getPrice())
                .creatorId(userId)
                .build();
        return this.repository.save(content).getId();
    }

    @Override
    public Content getContent(Long contentId) {
        return this.repository.findById(contentId)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
