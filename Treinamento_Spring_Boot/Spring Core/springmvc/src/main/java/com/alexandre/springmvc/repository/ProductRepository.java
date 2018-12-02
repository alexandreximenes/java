package com.alexandre.springmvc.repository;

import com.alexandre.springmvc.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
