package br.com.perceptron.marketplace.endereco;

import br.com.perceptron.marketplace.domains.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Endereco extends AbstractEntity {

    //    @Pattern(regexp = "\\d{3}/\\./\\d{3}", message = "{cep.invalid}")
    private String cep;
    private String logradouro;
    private String enderecoEntrega;
    private String numero;
    private String localidade;
    private String uf;

    public Endereco(EnderecoDTO e) {
        this.cep = e.getCep();
        this.logradouro = e.getLogradouro();
        this.enderecoEntrega = nonNull(e.getEnderecoEntrega()) ? e.getEnderecoEntrega() : e.getLogradouro();
        this.numero = e.getNumero();
        this.localidade = e.getLocalidade();
        this.uf = e.getUf();
    }
}
