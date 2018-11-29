package com.alexandre.springmvc.services.product;

import com.alexandre.springmvc.domains.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@Profile("map")
public class ProductServiceImpl implements ProductService {

    private Map<Integer, Product> products;

    @Override
    public List<Product> listaAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getById(Integer id) {
        Product product = products.get(id);
        if (product == null) {
            return null;
        }
        return product;
    }

    public Product saveOrUpdate(Product product) {
        if (product != null) {
            if (product.getId() == null) {
                Integer key = getNextKey();
                if (key > 0) {
                    product.setId(key);
                }
            }
            products.put(product.getId(), product);
            return product;

        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Product product = products.get(id);
        if(product!=null) {
            products.remove(id);
            return true;
        }
        return false;
    }

    private Integer getNextKey() {
        if (products.size() > 0)
            return Collections.max(products.keySet()) + 1;
        return -1;
    }

    public ProductServiceImpl() {
        loadProducts();
    }

    private void loadProducts() {
        products = new HashMap<>();

        Product product1 = new Product(1, "product 1", new BigDecimal("100"), "http://example.product1.jpg");
        Product product2 = new Product(2, "product 2", new BigDecimal("200"), "http://example.product2.jpg");
        Product product3 = new Product(3, "product 3", new BigDecimal("300"), "http://example.product3.jpg");
        Product product4 = new Product(4, "product 4", new BigDecimal("400"), "http://example.product4.jpg");
        Product product5 = new Product(5, "product 5", new BigDecimal("500"), "http://example.product5.jpg");

        products.put(1, product1);
        products.put(2, product2);
        products.put(3, product3);
        products.put(4, product4);
        products.put(5, product5);


    }


    @Override
    public Product getByName(String name) {
        return null;
    }
}
