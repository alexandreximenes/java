package br.com.perceptron.marketplace.cliente;

import br.com.perceptron.marketplace.domains.AbstractEntity;
import br.com.perceptron.marketplace.endereco.Endereco;
import br.com.perceptron.marketplace.endereco.EnderecoDTO;
import br.com.perceptron.marketplace.pedido.Pedido;
import br.com.perceptron.marketplace.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Cliente extends AbstractEntity {

    @NotBlank(message = "{not.blank}")
    private String nome;

    @Column(unique = true)
    private String codigo;

    @OneToOne
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;
    private boolean ativo;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @ElementCollection
    @CollectionTable(name = "telefones")
    private Set<String> telefones = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "Emails")
    private Set<String> emails = new HashSet<>();
    @OneToOne
    private Usuario usuario;

    public Cliente(ClienteDTO clienteDTO) {
        this.setId(clienteDTO.getId());
        this.nome = clienteDTO.getNome();
        this.codigo = clienteDTO.getCodigo();
        this.endereco = nonNull(clienteDTO.getEnderecoDTO()) ? EnderecoDTO.get(clienteDTO.getEnderecoDTO()) : null;
        this.tipo = clienteDTO.getTipo();
        this.ativo = clienteDTO.isAtivo();
        this.pedidos = nonNull(clienteDTO.getPedidosDTO()) ? Pedido.get(clienteDTO.getPedidosDTO()) : null;
        this.telefones = nonNull(clienteDTO.getTelefones()) ? clienteDTO.getTelefones() : null;
        this.emails = !CollectionUtils.isEmpty(clienteDTO.getEmails()) ? clienteDTO.getEmails() : null;


    }

    @Override
    public String toString() {
        return "Código: " + getId() + ", " + nome;
    }

    public static Cliente get(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO);
    }


}

