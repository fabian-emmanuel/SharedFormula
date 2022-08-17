package com.sharedformula.wallet.service;

import com.sharedformula.wallet.model.Wallet;
import com.sharedformula.wallet.payload.FundWalletRequest;
import com.sharedformula.wallet.payload.WalletDto;

import java.math.BigDecimal;

public interface WalletService {
    Long createWallet(Long userId);

    boolean fundWallet(Long walletId, FundWalletRequest request);

    WalletDto getWallet(Long walletId, Long userId);
}
