package br.com.perceptron.marketplace.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LoginDTO {
    @Email(message = "{username.not.valid}")
    @NotEmpty(message = "{not.blank}")
    private String username;
    @NotEmpty(message = "{not.blank}")
    private String password;

}
