package com.oauth2.demo.domain;

import lombok.*;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String firstName;
    private String lastName;
    @Email
    private String username;
    private String password;
    private boolean enable;
    private List<Role> roles = null;

    public UserDTO(User u) {
        this.id = u.getId();
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.username = u.getUsername();
        this.password = u.getPassword();
        this.enable = u.isEnable();
        this.roles = u.getRoles();
    }
}
