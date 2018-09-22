package br.com.alexandre.app.Cripto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserEncoder {

    private String password;

    public String encoder(String password){
        this.password = password;
        return new BCryptPasswordEncoder().encode(password);
    }
}
