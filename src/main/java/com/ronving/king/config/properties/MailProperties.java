package com.ronving.king.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "mail.settings")
@Getter
@Validated
public class MailProperties {
    @NotNull
    @Value("${mail.settings.host}")
    private String host;

    @NotNull
    @Value("${mail.settings.username}")
    private String username;

    @NotNull
    @Value("${mail.settings.password}")
    private String password;

    @NotNull
    @Value("${mail.settings.port}")
    private int port;

    @NotNull
    @Value("${mail.settings.protocol}")
    private String protocol;

    @NotNull
    @Value("${mail.settings.debug}")
    private String debug;

    @NotNull
    @Value("${mail.settings.auth}")
    private String auth;

    @NotNull
    @Value("${mail.settings.enable}")
    private String enable;

    @NotNull
    @Value("${mail.settings.domain}")
    private String domain;
}
