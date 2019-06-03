package br.com.perceptron.marketplace.cliente;

import br.com.perceptron.marketplace.endereco.EnderecoDTO;
import br.com.perceptron.marketplace.pedido.PedidoDTO;
import br.com.perceptron.marketplace.usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClienteDTO {

    private Long id;
    @Length(min = 2)
    @NotBlank(message = "{not.blank}")
    private String nome;
    @Length(min = 2)
    @Email(message = "{username.not.valid}")
    private Set<String> emails;
    private String codigo;
    private EnderecoDTO enderecoDTO;
    private List<PedidoDTO> pedidosDTO;
    private TipoCliente tipo;
    private boolean ativo;
    private Set<String> telefones = new HashSet<>();
    private UsuarioDTO usuarioDTO;

    public ClienteDTO(Cliente c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.codigo = c.getCodigo();
        this.emails = c.getEmails();
        this.tipo = c.getTipo();
        this.ativo = c.isAtivo();
        this.telefones = c.getTelefones();
    }

    public static List<ClienteDTO> get(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public static ClienteDTO get(Cliente cliente) {
        return new ClienteDTO(cliente);
    }
}
