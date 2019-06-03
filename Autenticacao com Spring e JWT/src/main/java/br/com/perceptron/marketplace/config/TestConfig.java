package br.com.perceptron.marketplace.config;

import br.com.perceptron.marketplace.bootstrap.DBService;
import br.com.perceptron.marketplace.email.EmailService;
import br.com.perceptron.marketplace.email.MockEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestConfig {

    private final DBService dbService;

    @Bean
    public boolean bootstrapDataBase() {
        dbService.init();
        return true;
    }

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }
}
