package com.oauth2.demo.security.oauth2;

import com.oauth2.demo.security.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${authorization-client}")
    private String authorizationClient;
    @Value("${authorization-secret}")
    private String authorizationSecret;
    @Value("${authorization-resourceId}")
    private String authorizationResourceId;
    @Value("${authorization-accessTokenValiditySecondsValue}")
    private int authorizationCccessTokenValiditySecondsValue;
    @Value("${authorization-refreshTokenValiditySecondsValue}")
    private int authorizationRefreshTokenValiditySecondsValue;
    @Value("${authorization-password}")
    private String authorizationPassword;
    @Value("${authorization-authorizationCode}")
    private String authorizationAuthorizationCode;
    @Value("${authorization-refreshToken}")
    private String authorizationRefreshToken;
    @Value("${authorization-bar}")
    private String authorizationBar;
    @Value("${authorization-read}")
    private String authorizationRead;
    @Value("${authorization-write}")
    private String authorizationWrite;


    @Qualifier("authenticationManagerBean")
    private final AuthenticationManager authenticationManager;
    private final UserDetailServiceImpl userDetailServiceImpl;
    private TokenStore tokenStore = new InMemoryTokenStore();

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(this.tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailServiceImpl);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(authorizationClient)
                .secret(new BCryptPasswordEncoder().encode(authorizationSecret))
                .authorizedGrantTypes(authorizationPassword, authorizationAuthorizationCode, authorizationRefreshToken)
                .scopes(authorizationBar, authorizationRead, authorizationWrite)
                .resourceIds(authorizationResourceId)
                .accessTokenValiditySeconds(authorizationCccessTokenValiditySecondsValue)
                .refreshTokenValiditySeconds(authorizationRefreshTokenValiditySecondsValue);
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setAccessTokenValiditySeconds(0);
        tokenServices.setTokenStore(this.tokenStore);
        return tokenServices;
    }
}
