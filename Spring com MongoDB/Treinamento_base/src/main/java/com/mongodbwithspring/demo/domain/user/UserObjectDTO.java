package com.mongodbwithspring.demo.domain.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserObjectDTO implements Serializable {

    private String id;
    @NotBlank
    private String nome;
    @Email
    private String email;

    public UserObjectDTO(UserObject u) {
        this.id = u.getId();
        this.nome = u.getNome();
        this.email = u.getEmail();
    }
}
