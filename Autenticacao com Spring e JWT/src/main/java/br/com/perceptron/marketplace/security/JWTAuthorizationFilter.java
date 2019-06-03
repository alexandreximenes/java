package br.com.perceptron.marketplace.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static br.com.perceptron.marketplace.security.Headers.AUTHORIZATION;
import static br.com.perceptron.marketplace.security.Headers.BEARER;
import static java.util.Objects.nonNull;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private String bearerToken;
    private JWTUtil jwtUtil;
    private UserDetailsService userDetailService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService userDetailService) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        bearerToken = request.getHeader(AUTHORIZATION);
        if (nonNull(bearerToken) && bearerToken.startsWith(BEARER)) {
            UsernamePasswordAuthenticationToken auth = getAuthenticationToken(BEARER);
            if (nonNull(auth))
                SecurityContextHolder.getContext().setAuthentication(auth);
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String bearerToken) {
        if (jwtUtil.tokenIsValid(bearerToken)) {
            String username = jwtUtil.getUsername(bearerToken);
            UserDetails userDetails = userDetailService.loadUserByUsername(username);
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }
        return null;
    }
}
