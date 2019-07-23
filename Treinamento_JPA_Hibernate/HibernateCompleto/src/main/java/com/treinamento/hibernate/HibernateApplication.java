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
    private CourseRepository repository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if(repository.findAll().size() <= 0)
            new InitData(repository).start();
    }
}
