package com.sharedformula.transaction.service;

import com.sharedformula.transaction.exceptions.ResourceNotFoundException;
import com.sharedformula.transaction.model.Transaction;
import com.sharedformula.transaction.payload.*;
import com.sharedformula.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final RestTemplate restTemplate;
    private final TransactionRepository repository;

    @Override
    public boolean initiateContentSale(Long contractorId, SaleRequest request) {
        Content content = this.getContent(request.getContentId());

        User contractor = this.getUser(contractorId);
        User client = this.getUser(request.getClientId());
        User creator = this.getUser(content.getCreatorId());


        Wallet contractorWallet = this.getWallet(contractor.getId(), contractor.getWalletId());
        Wallet creatorWallet = this.getWallet(creator.getId(), creator.getWalletId());
        Wallet clientWallet = this.getWallet(client.getId(), client.getWalletId());


        BigDecimal contentPrice = content.getPrice();
        BigDecimal clientPercentage = contentPrice.multiply(BigDecimal.valueOf(0.1));
        BigDecimal contractorPercentage = contentPrice.multiply(BigDecimal.valueOf(0.05));

        contractorWallet.setBalance(contractorWallet.getBalance().add(contractorPercentage));
        clientWallet.setBalance(clientWallet.getBalance().add(clientPercentage));

        contentPrice = contentPrice.subtract(clientPercentage).subtract(contractorPercentage);

        creatorWallet.setBalance(creatorWallet.getBalance().add(contentPrice));

        this.fundUserWallet(contractorWallet.getId(), new FundWalletRequest(contractor.getId(), contractorWallet.getBalance()));
        this.fundUserWallet(clientWallet.getId(), new FundWalletRequest(client.getId(), clientWallet.getBalance()));
        this.fundUserWallet(creatorWallet.getId(), new FundWalletRequest(creator.getId(), creatorWallet.getBalance()));

        var transaction = Transaction.builder()
                .contentId(content.getId())
                .clientId(request.getClientId())
                .contractorId(contractorId)
                .transactionDate(LocalDateTime.now())
                .build();

        return this.repository.save(transaction).getId() != null;
    }

    private void fundUserWallet(Long walletId, FundWalletRequest request) {
        this.restTemplate.postForObject(String.format("%s/%s/fund", "http://WALLET/api/v1/wallets", walletId),
                request, Boolean.class);
    }

    private Wallet getWallet(Long userId, Long walletId) {
        Wallet wallet =  this.restTemplate.getForObject(String.format("%s/%s/%s", "http://WALLET/api/v1/wallets",userId,walletId),
                Wallet.class);
        if(wallet != null) return wallet;
        else throw new ResourceNotFoundException("Wallet not found");
    }

    private User getUser(Long userId) {
        User user = this.restTemplate.getForObject(String.format("%s/%s", "http://USER/api/v1/users",userId),
                User.class);
        if (user != null) return user;
        else throw new ResourceNotFoundException("User not found");
    }

    private Content getContent(Long contentId) {
        Content content = this.restTemplate.getForObject(String.format("%s/%s", "http://CONTENT/api/v1/contents",contentId),
                Content.class);
        if (content != null) return content;
        else throw new ResourceNotFoundException("Content not found");
    }
}
