package com.sharedformula.wallet.service;

import com.sharedformula.wallet.exceptions.ResourceNotFoundException;
import com.sharedformula.wallet.model.Wallet;
import com.sharedformula.wallet.payload.FundWalletRequest;
import com.sharedformula.wallet.payload.WalletDto;
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
                .orElseThrow(()-> new ResourceNotFoundException("Wallet not found"));
        wallet.setBalance(wallet.getBalance().add(request.getAmount()));
        return this.repository.save(wallet).getId() != null;
    }

    @Override
    public WalletDto getWallet(Long walletId, Long userId) {
        Wallet wallet = this.repository.findByIdAndUserId(walletId, userId)
                .orElseThrow(()-> new ResourceNotFoundException("Wallet not found"));

        return new WalletDto(wallet.getBalance(), wallet.getUserId());
    }


}
