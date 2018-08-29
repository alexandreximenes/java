package br.com.alexandre.app.repository;

import br.com.alexandre.app.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1%")
    List<Student> findByName(String name);
    //List<Student> findByNameIgnoreCaseContaining(String name);
}
