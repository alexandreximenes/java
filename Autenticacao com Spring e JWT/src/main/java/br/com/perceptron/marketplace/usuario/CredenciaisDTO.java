package br.com.perceptron.marketplace.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredenciaisDTO {

    @NotEmpty(message = "Informe seu usuário")
    private String username;
    @NotEmpty(message = "Informe sua senha")
    private String password;
}

