package br.com.treinamento.springboot.demo.endpoint;

import br.com.treinamento.springboot.demo.error.ErrorType;
import br.com.treinamento.springboot.demo.model.Student;
import br.com.treinamento.springboot.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Student student = studentDAO.findOne(id);
        if (student == null)
            return new ResponseEntity<>(new ErrorType("Estudante não foi encontrado"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        studentDAO.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody Student student) {
        studentDAO.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
