package com.treinamento.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Slf4j
public class HibernateApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Autowired
    private CourseRepository cRepository;
    @Autowired
    private StudentRepository sRepository;
    @Autowired
    private PassportRepository pRepository;
    @Autowired
    private ReviewRepository rRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if(cRepository.findAll().size() <= 0)
            new InitData().startCourse(cRepository);

        if(pRepository.findAll().size() <= 0)
            new InitData().startPassport(pRepository);

        if(sRepository.findAll().size() <= 0)
            new InitData().startStudent(sRepository);

        new InitData().startStudentOneToOnePassport(sRepository, pRepository);

        if(rRepository.findAll().size() <= 0)
            new InitData().startReview(rRepository);
    }
}
