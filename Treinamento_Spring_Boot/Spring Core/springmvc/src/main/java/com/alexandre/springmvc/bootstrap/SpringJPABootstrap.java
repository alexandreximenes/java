package com.alexandre.springmvc.bootstrap;

import com.alexandre.springmvc.domains.Product;
import com.alexandre.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
    }

    private void loadProducts() {
        Product product1 = new Product("product 1", new BigDecimal("100"), "http://example.product1.jpg");
        productService.saveOrUpdate(product1);
        Product product2 = new Product("product 2", new BigDecimal("200"), "http://example.product2.jpg");
        productService.saveOrUpdate(product2);
        Product product3 = new Product("product 3", new BigDecimal("300"), "http://example.product3.jpg");
        productService.saveOrUpdate(product3);
        Product product4 = new Product("product 4", new BigDecimal("400"), "http://example.product4.jpg");
        productService.saveOrUpdate(product4);
        Product product5 = new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg");
        productService.saveOrUpdate(product5);
        Product product6 = new Product("product 6", new BigDecimal("600"), "http://example.product6.jpg");
        productService.saveOrUpdate(product6);
        Product product7 = new Product("product 7", new BigDecimal("700"), "http://example.product7.jpg");
        productService.saveOrUpdate(product7);
        Product product8 = new Product("product 8", new BigDecimal("800"), "http://example.product8.jpg");
        productService.saveOrUpdate(product8);
        Product product9 = new Product("product 9", new BigDecimal("900"), "http://example.product9.jpg");
        productService.saveOrUpdate(product9);
        Product product10 = new Product("product 10", new BigDecimal("1000"), "http://example.product10.jpg");
        productService.saveOrUpdate(product10);

    }
}
