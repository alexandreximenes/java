package com.oauth2.demo.security.oauth2;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@ConfigurationProperties("authorization")
public class AuthorizationConfigurationProperties {

    private String client;
    private String secret;
    private String resourceId;
    private String password;
    private String authorizationCode;
    private String refreshToken;
    private String bar;
    private String read;
    private String write;
    private int accessTokenValiditySecondsValue;
    private int refreshTokenValiditySecondsValue;
}
