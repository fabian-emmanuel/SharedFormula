package com.sharedformula.user.service;

import com.sharedformula.user.enumType.UserType;
import com.sharedformula.user.exceptions.ResourceNotFoundException;
import com.sharedformula.user.exceptions.UnAuthorizedException;
import com.sharedformula.user.model.User;
import com.sharedformula.user.payload.*;
import com.sharedformula.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final RestTemplate restTemplate;
    private final UserRepository repository;


    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        return this.createUser(userRequest);
    }

    @Override
    public UserDetailsResponse getUserDetails(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+userId));

        Wallet wallet = restTemplate.getForObject(String.format("%s/%s/%s", "http://WALLET/api/v1/wallets",user.getId(),user.getWalletId()),
                Wallet.class);

        if(wallet == null) {
            throw new ResourceNotFoundException("Wallet not found with id: "+user.getWalletId());
        }
        return UserDetailsResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .balance(wallet.getBalance())
                .build();
    }

    @Override
    public boolean createContent(Long userId, ContentRequest request) {
        User user = repository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+userId));

        if(!user.getUserType().equals(UserType.CREATOR)){
            throw new UnAuthorizedException("User is not authorized to create content");
        }

        Long contentId = restTemplate.postForObject(String.format("%s/%s", "http://CONTENT/api/v1/contents",user.getId()),
                request, Long.class);

        return contentId != null;
    }

    @Override
    public boolean sellContent(Long contractorId, SaleRequest request) {
        User user = repository.findById(contractorId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+contractorId));

        if(!user.getUserType().equals(UserType.CONTRACTOR)){
            throw new UnAuthorizedException("User is not authorized to sell content");
        }
        return Boolean.TRUE.equals(this.restTemplate.postForObject(String.format("%s/%s/initiate-sale", "http://TRANSACTION/api/v1/transactions", user.getId()),
                request, Boolean.class));
    }

    @Override
    public User getUser(Long userId) {
        return repository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+userId));
    }

    private UserResponse createUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .userType(UserType.valueOf(userRequest.getUserType()))
                .build();
        user =  this.repository.saveAndFlush(user);

        Long walletId = restTemplate.postForObject(String.format("%s/%s", "http://WALLET/api/v1/wallets",user.getId()),
                null,
                Long.class);

        user.setWalletId(walletId);
        user =  this.repository.saveAndFlush(user);
        return new UserResponse(user.getId(), user.getWalletId());
    }
}
