package com.treinamento.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public List<Course> findByName() {
        TypedQuery<Course> query = entityManager.createNamedQuery("select_all_courses", Course.class);
        return query.getResultList();
    }

    public List<Course> findByAllNativeQuery() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM course", Course.class);
        return nativeQuery.getResultList();
    }

    public Course findByNameNativeQueryPosition() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM course c where id = ?", Course.class);
        nativeQuery.setParameter(1, 2);
        return (Course) nativeQuery.getSingleResult();
    }

    public void updateNameCourse(String name, Long id) {
        Query query = entityManager.createNativeQuery("UPDATE course c set c.name=? where c.id=?");
        query.setParameter(1, name);
        query.setParameter(2, id);
        query.executeUpdate();
    }

    public Course findByNameParametter() {
        Query nativeQuery = entityManager.createQuery("SELECT c FROM course c where c.id = :id", Course.class);
        nativeQuery.setParameter("id", 2);
        return (Course) nativeQuery.getSingleResult();
    }
}
