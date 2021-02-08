package com.mycompany.exercicio5.security;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
public class SpringAutditingConfig {
//
//    @Bean
//    public AuditorAware<String> auditorAware() {
//        return new SpringSecuirtyAuditorAware();
//    }

}
