package br.com.perceptron.marketplace.usuario;

import br.com.perceptron.marketplace.domains.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Usuario extends AbstractEntity {

    @NotBlank(message = "{not.blank}")
    private String nome;
    @NotBlank(message = "{not.blank}")
    @Email(message = "{username.not.valid}")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "{not.blank}")
    private String password;
    @Column(columnDefinition = "boolean default 1")
    private Boolean ativo;
    private String token;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime ultimoAcesso;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis")
    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfis = new LinkedHashSet<>();

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil);
    }

}
