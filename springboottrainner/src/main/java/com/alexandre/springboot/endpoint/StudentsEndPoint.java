package com.alexandre.springboot.endpoint;

import com.alexandre.springboot.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsEndPoint {

    @RequestMapping(method = RequestMethod.GET, path="/list")
    public List<Student> students(){
        return Arrays.asList(new Student("alexandre", "ximenes"));
    }
}
