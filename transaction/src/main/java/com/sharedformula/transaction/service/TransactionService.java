package com.sharedformula.transaction.service;

import com.sharedformula.transaction.payload.SaleRequest;

public interface TransactionService {
    boolean initiateContentSale(Long contractorId, SaleRequest request);
}
