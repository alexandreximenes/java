package br.com.treinamento.springboot.demo.repository;

import br.com.treinamento.springboot.demo.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    //List<Student> findByNameIgnoreCaseContaining(String nome);



}
