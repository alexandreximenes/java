package br.com.perceptron.marketplace.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNomeContaining(String nome);

    @Query("SELECT c FROM Cliente c WHERE c.ativo = true")
    List<Cliente> findAllAtivos();

    Cliente findByCodigo(String codigo);
}
