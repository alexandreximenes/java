package com.treinamento.jdbctemplate.controllers;

import com.treinamento.jdbctemplate.PersonJdbcDao;
import com.treinamento.jdbctemplate.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonJdbcDao personJdbcDao;

    @GetMapping("/persons")
    public ResponseEntity<Object> all(){
//        List<Person> alexandre = Arrays.asList(new Person(1001, "alexandre", "Curitiba-PR", new Date()), new Person(1002, "dayane", "Curitiba-PR", new Date()));
//        return new ResponseEntity<List<Person>>(alexandre, HttpStatus.OK);
        return new ResponseEntity<Object>(personJdbcDao.findAll(), HttpStatus.OK);
    }
}
