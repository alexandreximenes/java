package com.alexandre.springmvc.services;

import com.alexandre.springmvc.domains.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJpaDao implements ProductService {
    private EntityManagerFactory emf;
    private Product productSaved;

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
        System.out.println("productRequest ========== "+productRequest);
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Product product = null;
        if(productRequest.getId()!=null){
            product = manager.merge(productRequest);
        }else{
            manager.persist(productRequest);
            product = manager.find(Product.class, productRequest.getId());
        }
        manager.getTransaction().commit();
        manager.close();
        return product;
    }

    @Override
    public boolean delete(Integer id) {
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Product product = manager.find(Product.class, id);
            if(product!=null)
                manager.remove(product);
            else
                System.out.println("produto não encontrado");
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
