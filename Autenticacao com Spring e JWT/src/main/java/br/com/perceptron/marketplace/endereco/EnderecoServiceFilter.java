package br.com.perceptron.marketplace.endereco;

public class EnderecoServiceFilter {
    public static Endereco get(EnderecoDTO addressDTO) {
        return new Endereco(addressDTO);
    }
}
