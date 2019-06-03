package br.com.perceptron.marketplace.security;

import br.com.perceptron.marketplace.response.ResponseDTO;
import br.com.perceptron.marketplace.usuario.LoginDTO;
import br.com.perceptron.marketplace.usuario.Usuario;
import br.com.perceptron.marketplace.usuario.UsuarioDTO;
import br.com.perceptron.marketplace.usuario.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static br.com.perceptron.marketplace.response.ResponseUtils.*;
import static br.com.perceptron.marketplace.security.Headers.AUTHORIZATION;
import static br.com.perceptron.marketplace.security.Headers.BEARER;
import static java.util.Objects.nonNull;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private ResponseDTO<JWTAuthenticationFilter> responseDTO = new ResponseDTO<>();
    private UsuarioService usuarioService;
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;
    private Usuario user = null;
    private MessageSource messageSource;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UsuarioService usuarioService, MessageSource messageSource) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioService = usuarioService;
        this.messageSource = messageSource;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        return getAuthenticationLoginAndPassword(request);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

        final UserSecurity userSecurity = UserSecurity.getUserPrincipal(authentication);

        if (nonNull(userSecurity)) {
            user = usuarioService.find(userSecurity.getId());
            String token = nonNull(user) ? jwtUtil.getToken(user.getUsername()) : null;
            user.setToken(token);
        }

        response.addHeader(AUTHORIZATION, BEARER.concat(user.getToken()));
        response.getWriter().println(responseDTO.success($200, searchOk(messageSource), new UsuarioDTO(user), this.getClass()));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        responseDTO.error($403, objectNotFound(messageSource), this.getClass(), "unsuccessfulAuthentication", null);
    }

    public Authentication getAuthenticationLoginAndPassword(HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = null;
        try {
            LoginDTO loginDTO = new ObjectMapper().readValue(request.getInputStream(), LoginDTO.class);
            authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword(), new ArrayList<>());
            responseDTO.success($200, searchOk(messageSource), authenticationToken, this.getClass());
        } catch (IOException e) {
            responseDTO.error($404, objectNotFound(messageSource), this.getClass(), "authentication", null);
        }
        return authenticationManager.authenticate(authenticationToken);
    }
}
