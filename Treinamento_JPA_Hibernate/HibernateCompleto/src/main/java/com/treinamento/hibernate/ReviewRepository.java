package com.treinamento.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReviewRepository {

    @Autowired
    EntityManager entityManager;

    public Review findById(Long id){

        Review review = entityManager.find(Review.class, id);

        return review;
    }

    public List<Review> findAll(){

        TypedQuery<Review> allReview = entityManager.createQuery("SELECT c FROM Review c", Review.class);
        List<Review> list = allReview.getResultList();
        return list;
    }

    public Review save(Review review){

        if(review.getId() == null)
            entityManager.persist(review);
        entityManager.merge(review);

        return review;
    }

    public void deleteById(Long id){

      Review review = entityManager.find(Review.class, id);

      entityManager.remove(review);

    }

    public List<Review> findByName() {
        TypedQuery<Review> query = entityManager.createNamedQuery("select_all_review", Review.class);
        return query.getResultList();
    }

    public List<Review> findByAllNativeQuery() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM review", Review.class);
        return nativeQuery.getResultList();
    }

    public Review findByNameNativeQueryPosition() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM review c where id = ?", Review.class);
        nativeQuery.setParameter(1, 2);
        return (Review) nativeQuery.getSingleResult();
    }

    public void updateNameReview(String name, Long id) {
        Query query = entityManager.createNativeQuery("UPDATE review c set c.name=? where c.id=?");
        query.setParameter(1, name);
        query.setParameter(2, id);
        query.executeUpdate();
    }

    public Review findByNameParametter() {
        Query nativeQuery = entityManager.createQuery("SELECT c FROM review c where c.id = :id", Review.class);
        nativeQuery.setParameter("id", 2);
        return (Review) nativeQuery.getSingleResult();
    }
}
