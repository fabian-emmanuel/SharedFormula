package com.sharedformula.wallet.service;

import com.sharedformula.wallet.model.Wallet;
import com.sharedformula.wallet.payload.FundWalletRequest;

import java.math.BigDecimal;

public interface WalletService {
    Long createWallet(Long userId);

    boolean fundWallet(Long walletId, FundWalletRequest request);

    Wallet getWallet(Long walletId, Long userId);
}
