package com.ronving.king.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "recaptcha")
@Getter
@Setter
@Validated
public class ReCaptchaProperties {
    @NotNull
    private String secret;
    @NotNull
    private String url;
}
