package com.ronving.king.service;

import com.ronving.king.domain.User;

public interface AuthService {
    User getAuthenticationPrincipal();
    boolean isCurrentUser(User user);
}
