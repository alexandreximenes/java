package br.com.alexandre.app.endpoint;

import br.com.alexandre.app.dateUtil.FormatDateTimeToLocalDate;
import br.com.alexandre.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("api")
public class StudentEndPoint {

    @Autowired
    private FormatDateTimeToLocalDate dateUtil;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Student> students() {
        System.out.println(dateUtil.formatDateTime(LocalDateTime.now()));
        return asList(new Student("alexandre"), new Student("arthur"));
    }
}
