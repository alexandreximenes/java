package com.treinamento.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PassportRepository {

    @Autowired
    EntityManager entityManager;

    public Passport findById(Long id){

        Passport passport = entityManager.find(Passport.class, id);

        return passport;
    }

    public List<Passport> findAll(){

        TypedQuery<Passport> allPassport = entityManager.createQuery("SELECT c FROM Passport c", Passport.class);
        List<Passport> list = allPassport.getResultList();
        return list;
    }

    public Passport save(Passport passport){

        if(passport.getId() == null)
            entityManager.persist(passport);
        entityManager.merge(passport);

        return passport;
    }

    public void deleteById(Long id){

      Passport passport = entityManager.find(Passport.class, id);

      entityManager.remove(passport);

    }

    public List<Passport> findByName() {
        TypedQuery<Passport> query = entityManager.createNamedQuery("select_all_passport", Passport.class);
        return query.getResultList();
    }

    public List<Passport> findByAllNativeQuery() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM passport", Passport.class);
        return nativeQuery.getResultList();
    }

    public Passport findByNameNativeQueryPosition() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM passport c where id = ?", Passport.class);
        nativeQuery.setParameter(1, 2);
        return (Passport) nativeQuery.getSingleResult();
    }

    public void updateNamePassport(String name, Long id) {
        Query query = entityManager.createNativeQuery("UPDATE passport c set c.name=? where c.id=?");
        query.setParameter(1, name);
        query.setParameter(2, id);
        query.executeUpdate();
    }

    public Passport findByNameParametter() {
        Query nativeQuery = entityManager.createQuery("SELECT c FROM passport c where c.id = :id", Passport.class);
        nativeQuery.setParameter("id", 2);
        return (Passport) nativeQuery.getSingleResult();
    }
}
