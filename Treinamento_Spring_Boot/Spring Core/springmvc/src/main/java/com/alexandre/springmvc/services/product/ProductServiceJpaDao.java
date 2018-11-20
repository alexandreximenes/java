package com.alexandre.springmvc.services.product;

import com.alexandre.springmvc.domains.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJpaDao implements ProductService {
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Product> listaAllProducts() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Product> list = manager.createQuery("from Product", Product.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;

    }

    @Override
    public Product getById(Integer id) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Product product = manager.find(Product.class, id);
        manager.getTransaction().commit();
        manager.close();
        return product;
    }

    @Override
    public Product saveOrUpdate(Product productRequest) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Product product = manager.merge(productRequest);
        manager.getTransaction().commit();
        manager.close();
        return product;
    }

    @Override
    public boolean delete(Integer id) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        try {
            Product product = manager.find(Product.class, id);
            if(product!=null)
                manager.remove(product);
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
