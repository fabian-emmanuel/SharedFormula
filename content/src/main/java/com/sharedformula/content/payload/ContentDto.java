package com.sharedformula.content.payload;

import lombok.*;

import java.math.BigDecimal;

public record ContentDto(String name, BigDecimal price, Long creatorId) {
}
