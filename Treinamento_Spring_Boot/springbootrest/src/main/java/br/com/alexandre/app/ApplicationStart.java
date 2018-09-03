package br.com.alexandre.app;

import br.com.alexandre.app.model.Cursos;
import br.com.alexandre.app.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import static java.util.Arrays.asList;

@SpringBootApplication
//@ComponentScan(basePackages = { "br.com.alexandre.app.endpoint", "br.com.alexandre.app.dateUtil"})
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }


}
