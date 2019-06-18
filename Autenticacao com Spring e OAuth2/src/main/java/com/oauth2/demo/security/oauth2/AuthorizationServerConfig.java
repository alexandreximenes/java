package com.oauth2.demo.security.oauth2;

import com.oauth2.demo.security.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private final AuthorizationConfigurationProperties properties;
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
                .withClient(this.properties.getClient())
                .secret(new BCryptPasswordEncoder().encode(this.properties.getSecret()))
                .authorizedGrantTypes(this.properties.getPassword(), this.properties.getAuthorizationCode(), this.properties.getRefreshToken())
                .scopes(this.properties.getBar(), this.properties.getRead(), this.properties.getWrite())
                .resourceIds(this.properties.getResourceId())
                .accessTokenValiditySeconds(this.properties.getAccessTokenValiditySecondsValue())
                .refreshTokenValiditySeconds(this.properties.getRefreshTokenValiditySecondsValue());
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
