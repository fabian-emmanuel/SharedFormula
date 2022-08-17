package com.sharedformula.content.service;

import com.sharedformula.content.exceptions.ResourceNotFoundException;
import com.sharedformula.content.model.Content;
import com.sharedformula.content.payload.ContentDto;
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
    public ContentDto getContent(Long contentId) {
        Content content =  this.repository.findById(contentId)
                .orElseThrow(()-> new ResourceNotFoundException("Content not found"));
        return new ContentDto( content.getName(), content.getPrice(), content.getCreatorId());
    }
}
