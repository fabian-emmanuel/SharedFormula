package com.sharedformula.wallet.service;

import com.sharedformula.wallet.exception.ResourceNotFoundException;
import com.sharedformula.wallet.model.Wallet;
import com.sharedformula.wallet.payload.FundWalletRequest;
import com.sharedformula.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository repository;
    @Override
    public Long createWallet(Long userId) {
        Wallet wallet =  Wallet.builder()
                .userId(userId)
                .balance(BigDecimal.ZERO)
                .build();
        return this.repository.save(wallet).getId();
    }

    @Override
    public boolean fundWallet(Long walletId, FundWalletRequest request) {
        Wallet wallet = this.repository.findByIdAndUserId(walletId, request.getUserId())
                .orElseThrow(ResourceNotFoundException::new);
        wallet.setBalance(wallet.getBalance().add(request.getAmount()));
        return this.repository.save(wallet).getId() != null;
    }

    @Override
    public Wallet getWallet(Long walletId, Long userId) {
        return this.repository.findByIdAndUserId(walletId, userId)
                .orElseThrow(ResourceNotFoundException::new);
    }


}
