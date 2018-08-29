package br.com.alexandre.springbootrest.repository;

import br.com.alexandre.springbootrest.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByNomeIgnoreCaseContaining(String nome);
}
