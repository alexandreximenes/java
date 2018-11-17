package com.alexandre.springmvc.services;

import com.alexandre.springmvc.domains.Product;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface ProductService {

    List<?> listaAllProducts();

    Product getById(Integer id);

    Product saveOrUpdate(Product product);

    boolean delete(Integer id);
}
