package br.com.perceptron.marketplace.endereco;

import br.com.perceptron.marketplace.response.ResponseDTO;
import br.com.perceptron.marketplace.usuario.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.perceptron.marketplace.response.ResponseUtils.*;

public class StartEnderecos {

    private ResponseDTO<Usuario> responseDTO = new ResponseDTO<>();

    public StartEnderecos(EnderecoRepository enderecoRepository) {
        insertData(enderecoRepository);
    }

    @Transactional
    void insertData(EnderecoRepository enderecoRepository) {

        try {

            Endereco endereco = null;
            Optional<Endereco> enderecoOp = enderecoRepository.findByCepAndLogradouroAndNumero("81920650", "Rua nova aurora", "1689");
            if (!enderecoOp.isPresent()) {
                endereco = new Endereco("81920650", "Rua nova aurora", "Rua nova aurora", "1689", "Curitiba", "PR");
                enderecoRepository.save(endereco);
            }

            responseDTO.success($200, ENDERECO + SALVO, this.getClass());
        } catch (Exception e) {
            responseDTO.error($404, NAO_SALVO + ENCONTRADO, this.getClass(), "insertData", e);
        }

    }
}
