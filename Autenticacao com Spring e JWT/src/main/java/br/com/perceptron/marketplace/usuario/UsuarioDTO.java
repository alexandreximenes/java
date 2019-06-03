package br.com.perceptron.marketplace.usuario;

import br.com.perceptron.marketplace.domains.AbstractEntityDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UsuarioDTO extends AbstractEntityDTO {

    @NotBlank(message = "{not.blank}")
    private String nome;
    @NotBlank(message = "{not.blank}")
    private String username;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedAt;
    private String token;
    private String password;
    private Boolean ativo;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime ultimoAcesso;
    private TokenDTO tokenAssinado;
    private Set<Perfil> perfis;

    public UsuarioDTO(Usuario user) {
        this.setId(user.getId());
        this.nome = user.getNome();
        this.username = user.getUsername();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.token = nonNull(user.getToken()) ? user.getToken() : null;
        this.ativo = user.getAtivo() ? user.getAtivo() : null;
        this.ultimoAcesso = user.getUltimoAcesso();
        this.perfis = !user.getPerfis().isEmpty() ? user.getPerfis() : null;
    }

    public static List<UsuarioDTO> get(List<Usuario> users) {
        return users.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
}
