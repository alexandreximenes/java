package com.jpaadvanced.start;

import com.jpaadvanced.start.entity.Course;
import com.jpaadvanced.start.entity.Passport;
import com.jpaadvanced.start.entity.Review;
import com.jpaadvanced.start.entity.Student;
import com.jpaadvanced.start.repository.CourseRepository;
import com.jpaadvanced.start.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.Arrays.asList;

@SpringBootApplication
public class StartApplication  implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course = courseRepository.findById(1L);
//        logger.info(""+course);
//        courseRepository.remove(1L);
//        logger.info("courseRepository.findAll() -> "+courseRepository.findAll());
//        logger.info("courseRepository.findAllWhere() -> "+courseRepository.findAllWhere());
//        logger.info("courseRepository.findAllNativeQuery() -> "+courseRepository.findAllNativeQuery());
//        courseRepository.statitistics();
//        logger.info("courseRepository.findAll() -> "+ courseRepository.findAll());
//        courseRepository.addCourseToListReview(course.getId(), asList(new Review("5", "description 1"), new Review("6", "description 2")));
//        logger.info("courseRepository.findAll() -> "+ courseRepository.findAll());
////        studentRepository.saveOrUpdateWithPassport(new Student(10L, "bruna"), new Passport(1L, "E55555553eff"));
//        logger.info("StudentRepository.findAll() -> "+ studentRepository.findAll());
    }
}

