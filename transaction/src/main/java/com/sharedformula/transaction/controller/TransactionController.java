package com.sharedformula.transaction.controller;

import com.sharedformula.transaction.payload.SaleRequest;
import com.sharedformula.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basepath-transaction}")
public class TransactionController {
    private final TransactionService service;

    @PostMapping("/{contractorId}/initiate-sale")
    public boolean initiateContentSale(@PathVariable Long contractorId, @RequestBody SaleRequest request){
        return this.service.initiateContentSale(contractorId, request);
    }

}
