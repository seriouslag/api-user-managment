package com.nullspace.apiusermanagement.service;

import com.nullspace.apiusermanagement.model.User;
import com.nullspace.apiusermanagement.security.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private final TokenHelper tokenHelper;

    @Autowired
    public SecurityService(TokenHelper tokenHelper) {
        this.tokenHelper = tokenHelper;
    }

    public boolean isUser(String authHeader, Long userId) {
        User user = tokenHelper.getUserFromAuthHeaderIfValid(authHeader);

        return user.getId().equals(userId);
    }
}