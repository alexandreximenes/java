package br.com.alexandre.springbootrest.endpoints;

import br.com.alexandre.springbootrest.error.ResourceNotFound;
import br.com.alexandre.springbootrest.model.Student;
import br.com.alexandre.springbootrest.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.alexandre.springbootrest.repository.StudentRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("api/")
public class StudentEndPoint {

    private final StudentRepository repository;

    @Autowired
    public StudentEndPoint(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Student student = this.repository.findOne(id);
        if(student == null) {
            ResourceNotFound resourceNotFound = new ResourceNotFound("Não foi possivel encontrar o recurso com ID : " + id);
            return new ResponseEntity<>(resourceNotFound, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("findByName/{nome}")
    public ResponseEntity<?> findByName(@PathVariable String nome){
        return new ResponseEntity<>(repository.findByNomeIgnoreCaseContaining(nome), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Student student) {
        this.repository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> put(@Valid @RequestBody Student student) {
        verifyIfStudentExists(student.getId());
        this.repository.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfStudentExists(id);
        this.repository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Student verifyIfStudentExists(Long id) {
        Student student = repository.findOne(id);
        if (student != null) return student;
        throw new ResourceNotFoundException("Não foi possivel encontrar o recurso solicitado com ID: " + id);

    }
}
