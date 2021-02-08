package com.mycompany.exercicio5.security;

import com.mycompany.exercicio5.domain.Usuario;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SpringSecurityAduitorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder
                .getContext().getAuthentication();
        if (auth == null || ! auth.isAuthenctited()){
            return null;
        }
        return((User) auth.getPrincipal()).getUsername();
    }
}
