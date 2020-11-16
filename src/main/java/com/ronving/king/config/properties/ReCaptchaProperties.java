package com.ronving.king.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "recaptcha")
@Getter
@Setter
public class ReCaptchaProperties {
    private String secret;
    private String url;
}
