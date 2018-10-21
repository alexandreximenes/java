package br.com.alexandre.app.config;

import br.com.alexandre.app.service.user.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //Utlizado somente na memoria - auth.inMemoryAuthentication()
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth){
//        try {
//            auth.inMemoryAuthentication()
//                    .withUser("alexandre").password("alexandre").roles("USER")
////                    .accountExpired(true)
////                    .credentialsExpired(true)
//                    .and()
//                    .withUser("admin").password("admin").roles("ADMIN", "USER")
//            ;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
