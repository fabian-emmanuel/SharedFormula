package com.sharedformula.wallet.repository;

import com.sharedformula.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    @Query("select w from Wallet w " +
            "where w.id = ?1 and w.userId = ?2")
    Optional<Wallet> findByIdAndUserId(Long walletId, Long userId);

}
