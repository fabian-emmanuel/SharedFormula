package com.sharedformula.content.service;

import com.sharedformula.content.model.Content;
import com.sharedformula.content.payload.ContentDto;
import com.sharedformula.content.payload.ContentRequest;

public interface ContentService {
    Long createContent(Long userId, ContentRequest contentRequest);
    ContentDto getContent(Long contentId);
}
