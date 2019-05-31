package com.mongodbwithspring.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document
public class UserObject implements Serializable {

    @Id
    private String id;
    @NotBlank
    private String nome;
    @Email
    private String email;

    public UserObject(UserObjectDTO u) {
        this.id = u.getId();
        this.nome = u.getNome();
        this.email = u.getEmail();
    }
}
