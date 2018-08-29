package br.com.alexandre.app.endpoint;

import br.com.alexandre.app.CustomMessage.Message;
import br.com.alexandre.app.dateUtil.FormatDateTimeToLocalDate;
import br.com.alexandre.app.model.Student;
import br.com.alexandre.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/api")
public class StudentEndPoint {

    @Autowired
    private StudentRepository studentDAO;

    @GetMapping()
    public ResponseEntity<?> students() {
        return new ResponseEntity<>(studentDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        Student student = new Student();
        student.setId(id);
        if(student == null)
            return new ResponseEntity<>(new Message("Não foi possivel encontrar id: " + id), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(studentDAO.findOne(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Student student){
        return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete (@RequestBody Student student){
        studentDAO.delete(student.getId());
        return new ResponseEntity<>(new Message("Estudante "+ student +" removido com sucesso!"), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        Student student = studentDAO.findOne(id);
        studentDAO.delete(id);
        return new ResponseEntity<>(new Message("Estudante "+ student +" removido com sucesso!"), HttpStatus.NO_CONTENT);

    }

    @PutMapping()
    public ResponseEntity<?> update (@RequestBody Student student){
        studentDAO.save(student);
        return new ResponseEntity<>(new Message("Estudante "+ student +" atualizado com sucesso!"), HttpStatus.OK);
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
