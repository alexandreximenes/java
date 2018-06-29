package br.com.treinamento.springboot.demo.endpoint;

import br.com.treinamento.springboot.demo.error.ErrorType;
import br.com.treinamento.springboot.demo.error.ResourceNotFoundException;
import br.com.treinamento.springboot.demo.model.Student;
import br.com.treinamento.springboot.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
public class StudentEndPoint {

    private StudentRepository studentDAO;

    @Autowired
    public StudentEndPoint(StudentRepository studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAllStudents() {
        return new ResponseEntity<>(studentDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        Student student = verifyIfStudentsExists(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> save(@Valid @RequestBody Student student) {
        studentDAO.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfStudentsExists(id);
        studentDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> put(@Valid @RequestBody Student student) {
        verifyIfStudentsExists(student.getId());
        studentDAO.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    private Student verifyIfStudentsExists(Long id){
        Student student = studentDAO.findOne(id);
        if (student == null)
            throw new ResourceNotFoundException("Recurso não encontrado com ID: "+id);
        return student;
    }

    @GetMapping("findByName/{nome}")
    public ResponseEntity<?> findStudentsByName(@PathVariable String nome){
        return new ResponseEntity<>(studentDAO.findByNomeIgnoreCaseContaining(nome), HttpStatus.OK);
    }
}
