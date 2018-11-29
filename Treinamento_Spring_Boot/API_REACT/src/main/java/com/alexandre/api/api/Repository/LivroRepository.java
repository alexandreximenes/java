package com.alexandre.api.api.Repository;

import com.alexandre.api.api.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Integer> {
}
