package com.jpaadvanced.start.repository;

import com.jpaadvanced.start.entity.Course;
import com.jpaadvanced.start.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CourseRepository implements CourseService<Course> {

    @Autowired
    EntityManager em;


//    private SessionFactory sessionFactory;
//    Session session;

    @Override
    public Course saveOrUpdate(Course course) {
        if(course.getId()==null) {
            em.persist(course);
            return course;
        }else{
            return em.merge(course);
        }
    }

    @Override
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    @Override
    public void remove(Long id) {
        Course byId = findById(id);
        em.remove(byId);
    }

    @Override
    public List<Course> findAll() {
        TypedQuery<Course> courses = em.createNamedQuery("SELECT.COURSES", Course.class);
        return courses.getResultList();
    }


    public List<Course> findAllWhere() {
        TypedQuery<Course> courses = em.createNamedQuery("SELECT.WHERE.COURSES", Course.class);
        return courses.getResultList();
    }
    public List<Course> findAllNativeQuery() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
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
