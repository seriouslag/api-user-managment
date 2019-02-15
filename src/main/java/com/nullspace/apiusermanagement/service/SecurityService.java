package com.nullspace.apiusermanagement.service;

import com.nullspace.apiusermanagement.model.User;
import com.nullspace.apiusermanagement.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class SecurityService {
    private final IUserService userService;

    @Autowired
    public SecurityService(IUserService userService) {
        this.userService = userService;
    }

    public boolean isUser(Principal principal, Long userId) {
        User user = userService.findByUsername(principal.getName());

        return user.getId().equals(userId);
    }
}
