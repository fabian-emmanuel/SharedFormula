package com.sharedformula.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "wallets", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id", "user_id"})
})
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "decimal(10,2) default (0)")
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}
