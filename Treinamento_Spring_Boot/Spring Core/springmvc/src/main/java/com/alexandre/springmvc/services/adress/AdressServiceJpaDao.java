package com.alexandre.springmvc.services.adress;

import com.alexandre.springmvc.Security.EncryptionService;
import com.alexandre.springmvc.domains.Adress;
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
public class AdressServiceJpaDao implements AdressService {
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
    public List<Adress> listaAllProducts() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Adress> list = manager.createQuery("from Adress", Adress.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;

    }

    @Override
    @Transactional
    public Adress getById(Integer id) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Adress adress = manager.find(Adress.class, id);
        manager.getTransaction().commit();
        manager.close();
        return adress;
    }

    @Override
    @Transactional
    public Adress saveOrUpdate(Adress adressRequest) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        Adress adress = manager.merge(adressRequest);
        manager.getTransaction().commit();
        manager.close();
        return adress;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        try {
            Adress adress = manager.find(Adress.class, id);
            if (adress != null)
                manager.remove(adress);
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
