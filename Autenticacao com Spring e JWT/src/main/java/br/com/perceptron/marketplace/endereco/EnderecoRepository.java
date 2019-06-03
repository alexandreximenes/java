package br.com.perceptron.marketplace.endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findByCepAndLogradouroAndNumero(String cep, String logradouro, String numero);
}
