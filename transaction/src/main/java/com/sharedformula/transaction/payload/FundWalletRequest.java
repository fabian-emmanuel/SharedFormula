package com.sharedformula.transaction.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class FundWalletRequest {
    private Long userId;
    private BigDecimal amount;
}
