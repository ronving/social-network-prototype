package com.ronving.king.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "mail.settings")
@Getter
@Setter
@Validated
public class MailProperties {
    @NotNull
    private String host;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private int port;

    @NotNull
    private String protocol;

    @NotNull
    private String debug;

    @NotNull
    private String auth;

    @NotNull
    private String enable;

    @NotNull
    private String domain;
}
