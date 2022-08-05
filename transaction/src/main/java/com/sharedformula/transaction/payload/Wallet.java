package com.sharedformula.transaction.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    private Long id;
    private BigDecimal balance;
    private Long userId;
}
