package com.treinamento.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    EntityManager entityManager;

    public Student findById(Long id){

        Student student = entityManager.find(Student.class, id);

        return student;
    }

    public List<Student> findAll(){

        TypedQuery<Student> allStudent = entityManager.createQuery("SELECT c FROM Student c", Student.class);
        List<Student> list = allStudent.getResultList();
        return list;
    }

    public Student save(Student student){

        if(student.getId() == null)
            entityManager.persist(student);
        entityManager.merge(student);

        return student;
    }

    public Student saveWithPassport(Student student){

        entityManager.persist(student);

        return student;
    }

    public void deleteById(Long id){

      Student student = entityManager.find(Student.class, id);

      entityManager.remove(student);

    }

    public List<Student> findByName() {
        return entityManager
                .createNamedQuery("select_all_students", Student.class)
                .getResultList();
    }

    public List<Student> findByAllNativeQuery() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM student", Student.class);
        return nativeQuery.getResultList();
    }

    public Student findByNameNativeQueryPosition() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM student c where id = ?", Student.class);
        nativeQuery.setParameter(1, 2);
        return (Student) nativeQuery.getSingleResult();
    }

    public void updateNameStudent(String name, Long id) {
        Query query = entityManager.createNativeQuery("UPDATE student c set c.name=? where c.id=?");
        query.setParameter(1, name);
        query.setParameter(2, id);
        query.executeUpdate();
    }

    public Student findByNameParametter() {
        Query nativeQuery = entityManager.createQuery("SELECT c FROM student c where c.id = :id", Student.class);
        nativeQuery.setParameter("id", 2);
        return (Student) nativeQuery.getSingleResult();
    }
}
