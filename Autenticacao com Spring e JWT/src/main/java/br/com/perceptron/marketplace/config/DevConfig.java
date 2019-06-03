package br.com.perceptron.marketplace.config;

import br.com.perceptron.marketplace.bootstrap.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DevConfig {

    private final DBService dbService;

    @Bean
    public boolean bootstrapDataBase() {
        dbService.init();
        return true;
    }
}
