package br.com.perceptron.marketplace.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.concurrent.TimeUnit;

public class Utils {
    public static void main(String[] args) {
        System.out.println("Tempo em dias -> " + TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
        System.out.println("BCryptPasswordEncoder.encode('admin') -> " + new BCryptPasswordEncoder().encode("admin"));
    }
}
