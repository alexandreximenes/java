package com.treinamento.jdbctemplate;

import com.treinamento.jdbctemplate.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        List<Person> query = jdbcTemplate.query("SELECT * FROM persons", new BeanPropertyRowMapper(Person.class));
        return query;
    }
}
