package com.ronving.king.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@Getter
@Validated
public class MailProperties {
    @NotNull
    @Value("${spring.mail.host}")
    private String host;

    @NotNull
    @Value("${spring.mail.username}")
    private String username;

    @NotNull
    @Value("${spring.mail.password}")
    private String password;

    @NotNull
    @Value("${spring.mail.port}")
    private int port;

    @NotNull
    @Value("${spring.mail.protocol}")
    private String protocol;

    @NotNull
    @Value("${mail.debug}")
    private String debug;

    @NotNull
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String auth;

    @NotNull
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String enable;

    @NotNull
    @Value("${mail.domain}")
    private String domain;
}
