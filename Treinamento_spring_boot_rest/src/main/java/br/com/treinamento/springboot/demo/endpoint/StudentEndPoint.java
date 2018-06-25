package br.com.treinamento.springboot.demo.endpoint;

import br.com.treinamento.springboot.demo.error.ErrorType;
import br.com.treinamento.springboot.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("api/")
public class StudentEndPoint {

    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "alexandre"));
        students.add(new Student(2,"Dayane"));
        students.add(new Student(3,"Arthur"));
    }

    @RequestMapping(method = RequestMethod.GET  )
    public ResponseEntity<?> listAllStudents(){
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id){
        Student student = new Student();
        student.setId(id);
        int index = students.indexOf(student);
        if(index == -1)
            return new ResponseEntity<>(new ErrorType("Estudante não foi encontrado"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(students.get(index), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student){
        students.add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Student student) {
        students.remove(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Student student){
        students.remove(student);
        students.add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
