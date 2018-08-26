package springbootprogram.model.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootprogram.model.model.Student;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentEndPoint {


    Student student = new Student();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> students (){
        return new ResponseEntity<>(Arrays.asList(
                new Student(1, "alexandre", "ximenes"),
                new Student(2, "dayane", "ximenes")), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentsById(@PathVariable("id") int id){
        student = new Student();
        student.setId(id);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student){
        student.setStudents(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        student.getStudents().remove(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Student student){
        student.getStudents().remove(student);
        student.getStudents().add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


}
