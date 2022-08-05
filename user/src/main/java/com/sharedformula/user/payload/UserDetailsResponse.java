package com.sharedformula.user.payload;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserDetailsResponse {
    private String name;
    private String email;
    private BigDecimal balance;
}
