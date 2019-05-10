package com.jpaadvanced.start.repository;

import com.jpaadvanced.start.entity.Passport;
import com.jpaadvanced.start.entity.Student;
import com.jpaadvanced.start.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class StudentRepository implements ServiceRepository<Student> {

    @Autowired
    EntityManager em;


//    private SessionFactory sessionFactory;
//    Session session;

    @Override
    public Student saveOrUpdate(Student student) {
        if(student.getId()==null) {
            em.persist(student);
            return student;
        }else{
            return em.merge(student);
        }
    }

    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public void remove(Long id) {
        Student byId = findById(id);
        em.remove(byId);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> students = em.createNamedQuery("SELECT.STUDENTS", Student.class);
        return students.getResultList();
    }


    public List<Student> findAllWhere() {
        TypedQuery<Student> students = em.createNamedQuery("SELECT.WHERE.STUDENTS", Student.class);
        return students.getResultList();
    }
    public List<Student> findAllNativeQuery() {
        Query query = em.createNativeQuery("SELECT * FROM STUDENT", Student.class);
        return query.getResultList();
    }

    public void statitistics() {
//        Statistics statistics = sessionFactory.getStatistics();
//        System.out.println("Quantidade total de Transacoes:" +
//                statistics.getTransactionCount());
//        System.out.println("Quantidade de Transacoes ok:" +
//                statistics.getSuccessfulTransactionCount());
//        System.out.println("getEntityNames():" +
//                statistics.getEntityNames());
//        System.out.println("getEntityLoadCount():" +
//                statistics.getEntityLoadCount());
//
//        statistics.logSummary();
    }
}
