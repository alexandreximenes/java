package com.treinamento.jdbctemplate;

import com.treinamento.jdbctemplate.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        List<Person> query = jdbcTemplate.query("SELECT * FROM persons", new BeanPropertyRowMapper(Person.class));
        return query;
    }

    public Person findById( int id ){
        return (Person) jdbcTemplate.queryForObject("SELECT * FROM persons where id=?", new Object[]{id},
                new BeanPropertyRowMapper(Person.class));
    }

    public int deleteById( int id ){
        return jdbcTemplate.update("DELETE FROM persons where id=?", new Object[]{id});
    }

    public int insert( Person person){
        return jdbcTemplate.update("insert into persons(id, name, location, birth_date) values (?,?,?,?)",
                person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
    }

    public int update( Person person){
        return jdbcTemplate.update("UPDATE persons SET name=?, location=?, birth_date=? WHERE id=?), " +
                new Object[]{
                        person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()
        });
    }



}
