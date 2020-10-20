package com.ronving.king.service;

import com.ronving.king.domain.User;

public interface UserService {
    boolean addUser(User user);
    boolean activateUser(String code);
}
