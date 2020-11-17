package com.ronving.king.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "upload")
@Getter
@Setter
@Validated
public class StaticDirectoryProperties {
    @NotNull
    private String path;
}
