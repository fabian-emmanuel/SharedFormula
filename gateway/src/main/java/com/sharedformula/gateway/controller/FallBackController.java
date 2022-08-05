package com.sharedformula.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/user-fallback")
    public String userFallBack() {
        return "User Service is Taking Longer Than Expected" +
                "Please Try Again Later!";
    }

    @GetMapping("/wallet-fallback")
    public String walletFallBack() {
        return "Wallet Service is Taking Longer Than Expected" +
                "Please Try Again Later!";
    }

    @GetMapping("/transaction-fallback")
    public String transactionFallBack() {
        return "Transaction Service is Taking Longer Than Expected" +
                "Please Try Again Later!";
    }


    @GetMapping("/content-fallback")
    public String contentFallBack() {
        return "Content Service is Taking Longer Than Expected" +
                "Please Try Again Later!";
    }

    @GetMapping("/documentation-fallback")
    public String documentationFallBack() {
        return "Documentation Service is Taking Longer Than Expected" +
                "Please Try Again Later!";
    }
}
