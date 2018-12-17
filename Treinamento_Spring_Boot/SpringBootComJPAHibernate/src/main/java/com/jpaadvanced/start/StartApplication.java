package com.jpaadvanced.start;

import com.jpaadvanced.start.entity.Course;
import com.jpaadvanced.start.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication  implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private CourseRepository repository;

    @Autowired
    public void setRepository(CourseRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Course byId = repository.findById(1L);
//        logger.info(""+byId);
//        repository.remove(1L);
//        logger.info("repository.findAll() -> "+repository.findAll());
//        logger.info("repository.findAllWhere() -> "+repository.findAllWhere());
//        logger.info("repository.findAllNativeQuery() -> "+repository.findAllNativeQuery());
//        repository.statitistics();
    }
}

