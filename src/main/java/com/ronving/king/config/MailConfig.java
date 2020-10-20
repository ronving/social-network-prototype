package com.ronving.king.config;

import com.ronving.king.config.properties.MailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class MailConfig {
    private final MailProperties mailProperties;

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(mailProperties.getHost());
        mailSender.setPort(mailProperties.getPort());
        mailSender.setUsername(mailProperties.getUsername());
        mailSender.setPassword(mailProperties.getPassword());

        Properties properties = mailSender.getJavaMailProperties();

        properties.setProperty("mail.transport.protocol", mailProperties.getProtocol());
        properties.setProperty("mail.debug", mailProperties.getDebug());
        properties.setProperty("mail.smtp.auth", mailProperties.getAuth());
        properties.setProperty("mail.smtp.starttls.enable", mailProperties.getEnable());

        return mailSender;
    }
}