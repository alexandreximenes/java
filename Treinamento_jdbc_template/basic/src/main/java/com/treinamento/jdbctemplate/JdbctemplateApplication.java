package com.treinamento.jdbctemplate;

import com.treinamento.jdbctemplate.bean.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JdbctemplateApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDao dao;

    public static void main(String[] args) {

        SpringApplication.run(JdbctemplateApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logs();
    }

    private void logs() {
        logger.info("All users -> {}" + dao.findAll());
        logger.info("Person user -> {}" + dao.findById(1001));
        logger.info("Delete user -> {}" + dao.deleteById(1002));
        logger.info("insert users -> {}" + dao.insert(new Person(1005, "Tiago", "SC", new Date())));
        logger.info("update users -> {}" + dao.update(new Person(1001, "ALexandre Ximenes", "USA", new Date())));
        logger.info("All users -> {}" + dao.findAll());
    }
}
