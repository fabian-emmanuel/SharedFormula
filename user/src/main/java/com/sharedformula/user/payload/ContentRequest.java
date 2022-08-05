package com.sharedformula.user.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContentRequest {
    private String name;
    private BigDecimal price;
}
