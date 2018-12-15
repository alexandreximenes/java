package com.springbootcomjpa2.start;

import com.springbootcomjpa2.start.bean.Person;
import com.springbootcomjpa2.start.repositories.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logs();
    }

    private void logs() {
        logger.info("Person user -> {}" + repository.findById(1001));
        logger.info("All users -> {}" + repository.findAll());
        logger.info("update users -> {}" + repository.update(new Person(1002, "ALexandre Ximenes", "USA", new Date())));
        logger.info("insert users -> {}" + repository.insert(new Person(1005, "Tiago", "SC", new Date())));
        logger.info("Delete user -> {} ID 1002 " + repository.delete(new Person(1002,"ALexandre Ximenes", "USA", new Date())));
        logger.info("All users -> {}" + repository.findAll());
    }
}

