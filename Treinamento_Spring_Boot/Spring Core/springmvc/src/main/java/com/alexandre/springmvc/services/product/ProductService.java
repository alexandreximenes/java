package com.alexandre.springmvc.services.product;

import com.alexandre.springmvc.domains.Product;
import com.alexandre.springmvc.services.CRUDService;

public interface ProductService extends CRUDService<Product> {

    Product getByName(String name);
}
