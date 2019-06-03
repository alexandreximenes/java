package br.com.perceptron.marketplace.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private Long id;
    //    @Pattern(regexp = "\\d{3}/\\./\\d{3}", message = "{cep.invalid}")
    private String cep;
    private String logradouro;
    private String enderecoEntrega;
    private String numero;
    private String localidade;
    private String uf;

    public EnderecoDTO(Endereco e) {
        this.id = e.getId();
        this.cep = e.getCep();
        this.logradouro = e.getLogradouro();
        this.enderecoEntrega = e.getEnderecoEntrega() != null ? e.getEnderecoEntrega() : e.getLogradouro();
        this.numero = e.getNumero();
        this.localidade = e.getLocalidade();
        this.uf = e.getUf();
    }

    public static Endereco get(EnderecoDTO enderecoDTO) {
        return new Endereco(enderecoDTO);
    }
}
