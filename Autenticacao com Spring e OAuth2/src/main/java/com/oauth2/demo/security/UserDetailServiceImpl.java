package com.oauth2.demo.security;

import com.oauth2.demo.domain.User;
import com.oauth2.demo.repository.UserRepository;
import com.oauth2.demo.resource.response.I18n;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final I18n i18n;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository
                .findByEmail(email)
                .filter(User::isEnable)
                .orElseThrow(() -> new UsernameNotFoundException(i18n.notFound() + " | " + i18n.userNotEnable()));
        return new User.UserUserDetail(user);

    }

}
