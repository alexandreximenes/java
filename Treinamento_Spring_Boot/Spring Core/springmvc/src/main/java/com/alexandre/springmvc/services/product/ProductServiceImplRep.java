package com.alexandre.springmvc.services.product;

import com.alexandre.springmvc.domains.Product;
import com.alexandre.springmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@Profile("springdatajpa")
public class ProductServiceImplRep implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getByName(String name) {
        return new Product();
    }

    @Override
    public List<Product> listaAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(Integer id) {
        productRepository.deleteById(id);
        return true;
    }
}
