package com.oauth2.demo.config;

import com.oauth2.demo.domain.User;
import com.oauth2.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Optional;

@Slf4j
@Configuration
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        load();
    }

    private void load() {

        User alexandre = getUser("Alexandre", "Ximenes", "xyymenes@gmail.com");
        User dayane = getUser("Dayane", "Ximenes", "x0menes@gmail.com");

        createUserIfNotExistsByEmail(alexandre);
        createUserIfNotExistsByEmail(dayane);

    }

    private User getUser(String firstName, String lastName, String email) {
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
    }

    private User createUserIfNotExistsByEmail(User user) {

        Optional<User> userByEmail = userRepository.findByEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            log.info("return user already : " + userByEmail.get().getFirstName());
            return userByEmail.get();
        }
        log.info("return new User : " + user.getFirstName());
        return userRepository.save(user);
    }

}
