package com.sharedformula.wallet.controller;

import com.sharedformula.wallet.model.Wallet;
import com.sharedformula.wallet.payload.FundWalletRequest;
import com.sharedformula.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basepath-wallet}")
public class WalletController {
    private final WalletService service;

    @PostMapping("/{userId}")
    public Long createWallet(@PathVariable Long userId){
        return service.createWallet(userId);
    }

    @PostMapping("/{walletId}/fund")
    public boolean fundWallet(@PathVariable Long walletId, @RequestBody FundWalletRequest request){
        return service.fundWallet(walletId,request);
    }

    @GetMapping("/{userId}/{walletId}")
    public Wallet getWallet(@PathVariable Long walletId, @PathVariable Long userId){
        return service.getWallet(walletId,userId);
    }

}
