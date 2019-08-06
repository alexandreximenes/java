package com.oauth2.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Email
    private String username;
    private String password;
    private boolean enable;

    @DBRef(lazy = true)
    private List<Role> roles;

    public User(UserDTO u) {
        this.id = u.getId();
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.username = u.getUsername();
    }

    public User(User u) {
        this.id = u.getId();
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.username = u.getUsername();
        this.password = u.getPassword();
        this.enable = u.isEnable();
        this.roles = u.getRoles();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Getter
    @Setter
    public final static class UserUserDetail extends User implements UserDetails {

        public UserUserDetail(User user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.getRoles().parallelStream()
                    .filter(Objects::nonNull)
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
        }

        @Override
        public String getPassword() {
            return getPassword();
        }

        @Override
        public String getUsername() {
            return getUsername();
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
