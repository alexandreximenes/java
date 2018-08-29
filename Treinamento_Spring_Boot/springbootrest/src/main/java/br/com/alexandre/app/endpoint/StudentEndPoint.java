package br.com.alexandre.app.endpoint;

import br.com.alexandre.app.CustomMessage.Message;
import br.com.alexandre.app.dateUtil.FormatDateTimeToLocalDate;
import br.com.alexandre.app.model.Student;
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
    private FormatDateTimeToLocalDate dateUtil;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ResponseEntity<?> students() {
        return new ResponseEntity<>(Student.getList(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
        Student s = new Student();
        s.setId(id);

        int index = Student.getList().indexOf(s);
        if(index == -1)
            return new ResponseEntity<>(new Message("Não foi possivel encontrar id: " + id), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Student.getList().get(index), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student){
        Student.getList().add(student);
        return new ResponseEntity<>(Student.getList(), HttpStatus.OK);
    }


}
