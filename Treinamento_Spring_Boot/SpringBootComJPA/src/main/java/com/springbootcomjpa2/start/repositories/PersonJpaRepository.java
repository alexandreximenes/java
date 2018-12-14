package com.springbootcomjpa2.start.repositories;

import com.springbootcomjpa2.start.bean.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.security.Timestamp;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {


    @PersistenceContext
    EntityManager entityManager;

    public Person findById( int id ){
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll(){
        TypedQuery<Person> query = entityManager.createNamedQuery("select.all.persons", Person.class);
        return query.getResultList();
    }

    public String delete(Person person){
        Person personR = entityManager.find(Person.class, person.getId());
        if(personR != null){
            entityManager.remove(personR);
            return "deletado com sucesso";
        }
        return "Não conseguiu deletar";
    }
//
    public Person insert( Person person){
        return entityManager.merge(person);
    }

    public Person update( Person person){
        return entityManager.merge(person);
    }

}
