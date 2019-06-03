package br.com.perceptron.marketplace.security;

import br.com.perceptron.marketplace.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import static java.util.Arrays.asList;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private Environment environment;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private UnauthorizedHandler unauthorizedHandler;


    public static final String[] PUBLIC_MATCHERS = {
            "/login/**",
            "/actuator/**",
            "/#/applications/**",
            "/swagger-ui.html/**",
            "/browser/**",
            "/v2/api-docs/**",
            "/**/favicon.ico/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        if (asList(environment.getActiveProfiles()).contains("dev"))
            http.headers().frameOptions().disable();

        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/*/v1/api/**").hasRole("USER")
                .and()
                .addFilter(new CorsConfig())
                .addFilter(jwtAuthenticationFilter())
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil, usuarioService, messageSource))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    public JWTAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter(authenticationManager(), jwtUtil, usuarioService, messageSource);
        jwtAuthenticationFilter.setFilterProcessesUrl("/api/v1/login/**");
        return jwtAuthenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
