package com.alexandre.springmvc.services.user;

import com.alexandre.springmvc.Security.EncryptionService;
import com.alexandre.springmvc.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class UserServiceJpaDao implements UserService {
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EncryptionService encryptionService;

    @Autowired
    public EncryptionService getEncryptionService() {
        return encryptionService;
    }

    @Override
    public List<User> listaAllProducts() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<User> list = manager.createQuery("from User", User.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;

    }

    @Override
    @Transactional
    public User getById(Integer id) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User user = manager.find(User.class, id);
        manager.getTransaction().commit();
        manager.close();
        return user;
    }

    @Override
    @Transactional
    public User saveOrUpdate(User userRequest) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        User User = manager.merge(userRequest);
        manager.getTransaction().commit();
        manager.close();
        return User;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        try {
            User user = manager.find(User.class, id);
            if (user != null)
                manager.remove(user);
            manager.getTransaction().commit();
            manager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
            manager.close();
            return false;
        }
    }
}
