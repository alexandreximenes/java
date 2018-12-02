package com.alexandre.springmvc.config;

import com.alexandre.springmvc.services.adress.AdressService;
import com.alexandre.springmvc.services.adress.AdressServiceJpaDao;
import com.alexandre.springmvc.services.user.UserService;
import com.alexandre.springmvc.services.user.UserServiceJpaDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Configuration
@EnableJpaRepositories("com.alexandre.springmvc.repository")
public class CommonBeanConfig {

    @Bean
    public AdressService adressService(){
        return new AdressServiceJpaDao();
    }
    @Bean
    public UserService userService(){
        return new UserServiceJpaDao();
    }

}
