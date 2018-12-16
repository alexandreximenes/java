package com.alexandre.api.api.Repository;

import com.alexandre.api.api.model.Autor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutorRepository extends CrudRepository<Autor, Integer> {

    @Query(
            "SELECT a.nome, a.email " +
            "FROM Autor a " +
            "ORDER BY a.id DESC"
          )
    List<Autor> findAllOrderByIdDesc();
}
