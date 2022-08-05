package com.sharedformula.transaction.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private Long id;
    private String name;
    private BigDecimal price;
    private Long creatorId;
}
