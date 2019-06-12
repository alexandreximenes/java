package com.oauth2.demo.config;

import com.oauth2.demo.domain.Role;
import com.oauth2.demo.domain.User;
import com.oauth2.demo.repository.RoleRepository;
import com.oauth2.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;
import java.util.Optional;

@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        load();
    }

    private void load() {

        Role adminRole = getNewRole("ROLE_ADMIN");
        Role userRole = getNewRole("ROLE_USER");

        User alexandre = getUser("Alexandre", "Ximenes", "xyymenes@gmail.com");
        User dayane = getUser("Dayane", "Ximenes", "x0menes@gmail.com");

        alexandre.setRoles(List.of(adminRole));
        dayane.setRoles(List.of(userRole));

        createRoleIfNotExistsByName(adminRole);
        createRoleIfNotExistsByName(userRole);

        createUserIfNotExistsByEmail(alexandre);
        createUserIfNotExistsByEmail(dayane);

    }

    private Role getNewRole(String name) {
        return Role.builder()
                .name(name)
                .build();
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

    private Role createRoleIfNotExistsByName(Role role) {

        Optional<Role> roleByName = roleRepository.findByName(role.getName());
        if (roleByName.isPresent()) {
            log.info("return role already : " + roleByName.get().getName());
            return roleByName.get();
        }
        log.info("return new Role : " + role.getName());
        return roleRepository.save(role);
    }

}
