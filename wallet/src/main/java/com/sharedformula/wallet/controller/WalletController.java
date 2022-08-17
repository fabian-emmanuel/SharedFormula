package com.sharedformula.wallet.controller;

import com.sharedformula.wallet.apiresponse.ApiDataResponse;
import com.sharedformula.wallet.model.Wallet;
import com.sharedformula.wallet.payload.FundWalletRequest;
import com.sharedformula.wallet.payload.WalletDto;
import com.sharedformula.wallet.service.WalletService;
import com.sharedformula.wallet.util.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basepath-wallet}")
public class WalletController {
    private final WalletService service;

    @PostMapping("/{userId}")
    public ResponseEntity<ApiDataResponse<Long>> createWallet(@PathVariable Long userId){
        return ApiResponseUtil.response(HttpStatus.CREATED, service.createWallet(userId), "Wallet created successfully");
    }

    @PostMapping("/{walletId}/fund")
    public ResponseEntity<ApiDataResponse<Boolean>> fundWallet(@PathVariable Long walletId, @RequestBody FundWalletRequest request){
        return ApiResponseUtil.response(HttpStatus.OK,service.fundWallet(walletId,request),"Funded successfully");
    }

    @GetMapping("/{userId}/{walletId}")
    public ResponseEntity<ApiDataResponse<WalletDto>> getWallet(@PathVariable Long walletId, @PathVariable Long userId){
        return ApiResponseUtil.response(HttpStatus.OK, service.getWallet(walletId,userId),"Wallet Details retrieved successfully");
    }

}
