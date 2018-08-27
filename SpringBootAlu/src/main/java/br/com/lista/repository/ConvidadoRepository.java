package br.com.lista.repository;

import br.com.lista.model.Convidado;
import org.springframework.data.repository.CrudRepository;


public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
}
