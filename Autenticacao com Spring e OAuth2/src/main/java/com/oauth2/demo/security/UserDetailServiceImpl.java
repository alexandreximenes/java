package com.oauth2.demo.security;

import com.oauth2.demo.domain.Role;
import com.oauth2.demo.domain.User;
import com.oauth2.demo.repository.UserRepository;
import com.oauth2.demo.resource.response.I18n;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return new UserRepositoryUserDetail(user);

    }

    public final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
        return grantedAuthorityList(roles);
    }

    private final List<GrantedAuthority> grantedAuthorityList(final Collection<Role> roles) {
        return roles.parallelStream()
                .filter(Objects::nonNull)
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    private final static class UserRepositoryUserDetail extends User implements UserDetails {

        public UserRepositoryUserDetail(User user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return getRoles();
        }

        @Override
        public String getPassword() {
            return getPassword();
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
