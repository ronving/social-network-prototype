package com.ronving.king.service;

public interface MailSenderService {
    void send(String emailTo, String subject, String message);
}
