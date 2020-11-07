package com.ronving.king.service.impl;

import com.ronving.king.domain.User;
import com.ronving.king.repos.UserRepo;
import com.ronving.king.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    @Override
    public User getAuthenticationPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepo.findByUsername(username);
        return user;
    }
}
