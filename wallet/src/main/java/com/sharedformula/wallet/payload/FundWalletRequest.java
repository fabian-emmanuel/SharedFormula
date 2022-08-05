package com.sharedformula.wallet.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundWalletRequest {
    private Long userId;
    private BigDecimal amount;
}
