package com.sharedformula.transaction.controller;

import com.sharedformula.transaction.apiresponse.ApiDataResponse;
import com.sharedformula.transaction.payload.SaleRequest;
import com.sharedformula.transaction.service.TransactionService;
import com.sharedformula.transaction.util.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basepath-transaction}")
public class TransactionController {
    private final TransactionService service;

    @PostMapping("/{contractorId}/initiate-sale")
    public ResponseEntity<ApiDataResponse<Boolean>> initiateContentSale(@PathVariable Long contractorId, @RequestBody SaleRequest request){
        return ApiResponseUtil.response(HttpStatus.OK, this.service.initiateContentSale(contractorId, request), "Content sale initiated successfully");
    }

}
