package com.sharedformula.wallet.payload;

import java.math.BigDecimal;

public record WalletDto(BigDecimal balance, Long userId) {
}
