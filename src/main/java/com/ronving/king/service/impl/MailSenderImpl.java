package com.ronving.king.service.impl;

import com.ronving.king.config.properties.MailProperties;
import com.ronving.king.domain.User;
import com.ronving.king.service.MailSenderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
class MailSenderImpl implements MailSenderService {
    @NonNull
    private JavaMailSender mailSender;
    private final MailProperties mailProperties;

    @Override
    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(mailProperties.getUsername());
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }

    @Override
    public void createActivationMessage(User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to VTCSN. Please, visit next link: %s/activate/%s",
                    user.getUsername(),
                    mailProperties.getDomain(),
                    user.getActivationCode()
            );

            send(user.getEmail(), "Activation code", message);
        }
    }
}