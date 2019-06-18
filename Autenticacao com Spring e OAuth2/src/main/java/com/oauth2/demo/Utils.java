package com.oauth2.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Utils {
    public static void main(String[] args) {
        log.info("Tempo em dias '{}'", TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
        log.info("BCryptPasswordEncoder.encode('admin') '{}'", new BCryptPasswordEncoder().encode("admin"));
    }
}
