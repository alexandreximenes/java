package br.com.alexandre.app.endpoint;

import br.com.alexandre.app.CustomMessage.ErrorMessage;
import br.com.alexandre.app.CustomMessage.Message;
import br.com.alexandre.app.model.Student;
import br.com.alexandre.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentEndPoint {

    @Autowired
    private StudentRepository studentDAO;

    @GetMapping()
    public ResponseEntity<?> students(Pageable pageable) {
        return new ResponseEntity<>(studentDAO.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name){
        return new ResponseEntity<>(studentDAO.findByName(name), HttpStatus.OK);
        //return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        verifyIfExistsStudents(id);
        return new ResponseEntity<>(studentDAO.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> save(@Valid @RequestBody Student student){
        return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete (@RequestBody Student student){
        verifyIfExistsStudents(student.getId());
        studentDAO.deleteById(student.getId());
        return new ResponseEntity<>(new Message("Estudante "+ student +" removido com sucesso!"), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        verifyIfExistsStudents(id);
        Optional<Student> student = studentDAO.findById(id);
        studentDAO.deleteById(id);
        return new ResponseEntity<>(new Message("Estudante "+ student +" removido com sucesso!"), HttpStatus.NO_CONTENT);

    }

    @PutMapping()
    public ResponseEntity<?> update (@RequestBody Student student){
        verifyIfExistsStudents(student.getId());
        studentDAO.save(student);
        return new ResponseEntity<>(new Message("Estudante "+ student +" atualizado com sucesso!"), HttpStatus.OK);
    }

    private void verifyIfExistsStudents(Long id) {
        if(studentDAO.findById(id) == null)
            throw new ErrorMessage("Não foi possivel encontrar id: " + id);
    }



    /**
     *
     *
     *
     *
     *
     * Projeto teste que foi substituido pelo projeto acima
     */
    /*@Autowired
    private FormatDateTimeToLocalDate dateUtil;

    //@RequestMapping(method = RequestMethod.GET, path = "/list")
    @GetMapping()
    public ResponseEntity<?> students() {
        return new ResponseEntity<>(Student.getList(), HttpStatus.OK);

    }

    //@RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
        Student s = new Student();
        s.setId(id);

        int index = Student.getList().indexOf(s);
        if(index == -1)
            return new ResponseEntity<>(new Message("Não foi possivel encontrar id: " + id), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Student.getList().get(index), HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Student student){
        Student.getList().add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.DELETE)
    @DeleteMapping
    public ResponseEntity<?> delete (@RequestBody Student student){
        Student.getList().remove(student);
        return new ResponseEntity<>(new Message("Estudante "+ student +" removido com sucesso!"), HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id){
        Student student = new Student();
        student.setId(id);

        int indexOf = Student.getList().indexOf(student);
        if(indexOf == -1)
            return new ResponseEntity<>(new Message("Não foi possivel excluir estudante com id: "+id), HttpStatus.NOT_FOUND);

        student = Student.getList().get(indexOf);
        Student.getList().remove(student);

        return new ResponseEntity<>(new Message("Estudante "+ student +" removido com sucesso!"), HttpStatus.OK);

    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping()
    public ResponseEntity<?> update (@RequestBody Student student){
        Student.getList().remove(student);
        Student.getList().add(student);
        return new ResponseEntity<>(new Message("Estudante "+ student +" atualizado com sucesso!"), HttpStatus.OK);
    }*/

}
