package com.treinamento.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){

        Course course = entityManager.find(Course.class, id);

        return course;
    }

    public List<Course> findAll(){

        TypedQuery<Course> allCourse = entityManager.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> list = allCourse.getResultList();
        return list;
    }

    public Course save(Course course){

        if(course.getId() == null)
            entityManager.persist(course);
        entityManager.merge(course);

        return course;
    }

    public void deleteById(Long id){

      Course course = entityManager.find(Course.class, id);

      entityManager.remove(course);

    }

}
