package com.oauth2.demo.domain;

import lombok.*;

import javax.validation.constraints.Email;
import java.io.Serializable;

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
    private String email;

    public UserDTO(User u) {
        this.id = u.getId();
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.email = u.getEmail();
    }
}
