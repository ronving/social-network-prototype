package com.ronving.king.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@JsonIgnoreProperties
@Getter
@Setter
public class CaptchaResponse {
    private boolean success;
    @JsonAlias("error-codes")
    private Set<String> errorCodes;
}
