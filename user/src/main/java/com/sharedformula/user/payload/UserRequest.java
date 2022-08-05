package com.sharedformula.user.payload;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String userType;
}
