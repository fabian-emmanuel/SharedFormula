package com.sharedformula.user.service;

import com.sharedformula.user.model.User;
import com.sharedformula.user.payload.*;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
    UserDetailsResponse getUserDetails(Long userId);
    boolean createContent(Long userId, ContentRequest request);
    boolean sellContent(Long contractorId, SaleRequest request);

    User getUser(Long userId);
}
