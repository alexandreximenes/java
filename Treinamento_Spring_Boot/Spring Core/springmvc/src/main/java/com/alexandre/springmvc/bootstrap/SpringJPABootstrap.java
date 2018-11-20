package com.alexandre.springmvc.bootstrap;

import com.alexandre.springmvc.domains.Adress;
import com.alexandre.springmvc.domains.Product;
import com.alexandre.springmvc.domains.User;
import com.alexandre.springmvc.services.adress.AdressService;
import com.alexandre.springmvc.services.product.ProductService;
import com.alexandre.springmvc.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;
    private UserService userService;
    private AdressService adressService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAdressService(AdressService adressService) {
        this.adressService = adressService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadUsers();
    }

    private void loadUsers() {
        boolean ativo = true;
        Adress rua_x = adressService.saveOrUpdate(new Adress("rua x", "1"));
        Adress rua_a = adressService.saveOrUpdate(new Adress("rua a", "1"));
        Adress rua_b = adressService.saveOrUpdate(new Adress("rua b", "1"));
        Adress rua_c = adressService.saveOrUpdate(new Adress("rua c", "1"));
        Adress rua_d = adressService.saveOrUpdate(new Adress("rua d", "1"));
        Adress rua_e = adressService.saveOrUpdate(new Adress("rua e", "1"));
        Adress rua_f = adressService.saveOrUpdate(new Adress("rua f", "1"));

        User user = new User("Alexandre", "123", rua_x, ativo);
        User user2 = new User("Dayane", "123", rua_a, !ativo);
        User user3 = new User("Michele", "123", rua_b, ativo);
        User user4 = new User("Adriano", "123", rua_c, !ativo);
        User user5 = new User("Rodrigo", "123", rua_d, ativo);
        User user6 = new User("Amanda", "123", rua_e, !ativo);
        User user7 = new User("Arthur", "123",rua_f , ativo);

        userService.saveOrUpdate(user);
        userService.saveOrUpdate(user2);
        userService.saveOrUpdate(user3);
        userService.saveOrUpdate(user4);
        userService.saveOrUpdate(user5);
        userService.saveOrUpdate(user6);
        userService.saveOrUpdate(user7);
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
