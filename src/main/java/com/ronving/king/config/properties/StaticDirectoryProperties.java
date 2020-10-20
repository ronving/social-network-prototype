package com.ronving.king.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "upload")
@Getter
@Validated
public class StaticDirectoryProperties {
    @Value("${upload.path}")
    private String uploadPath;
}
