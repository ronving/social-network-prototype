package com.ronving.king.service;

import com.ronving.king.domain.User;

public interface MailSenderService {
    void send(String emailTo, String subject, String message);
    void createActivationCode(User user);
}
