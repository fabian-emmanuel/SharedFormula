package com.sharedformula.transaction.payload;

import com.sharedformula.transaction.enumType.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private UserType userType;
    private Long walletId;
}
