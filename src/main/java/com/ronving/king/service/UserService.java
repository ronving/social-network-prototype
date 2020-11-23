package com.ronving.king.service;

import com.ronving.king.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface UserService extends UserDetailsService {
    List<User> findAll();

    boolean addUser(User user);
    boolean activateUser(String code);

    void saveUser(User user, String username, Map<String, String> form);
    void deleteUser(User user);

    User updateProfile(User user, String password, String email);
    User findByUsername(String name);

    void subscribe(User currentUser, User user);
    void unsubscribe(User currentUser, User user);
}
