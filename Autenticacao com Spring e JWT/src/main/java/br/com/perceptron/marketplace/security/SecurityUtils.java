package br.com.perceptron.marketplace.security;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SecurityUtils {

    public static String newPassword() {
        String uuidString = UUID.randomUUID().toString();
        return uuidString.substring(0, 6).toUpperCase();
    }
}
