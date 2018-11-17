package com.alexandre.springmvc.controllers;

import com.alexandre.springmvc.domains.Product;
import com.alexandre.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product")
    public String listAllProducts(Model model) {
        model.addAttribute("products", productService.listaAllProducts());
        return "products";
    }

    @RequestMapping("/product/{id}")
    public String getProductById(@PathVariable Integer id, Model model) {
        Product product = productService.getById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product";
        }
        return pageError();
    }

    private String pageError() {
        return "erro";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg"));
        return "newproduct";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        System.out.println("************************************** "+product);
        Product productSaved = productService.saveOrUpdate(product);
        if (productSaved != null) {
            System.out.println(productSaved);
        }

        return "redirect:/product/" + productSaved.getId();
//        return "erro";
    }

    @RequestMapping("/product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "newproduct";
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        if (productService.delete(id)) {
            System.out.println("****************************** produto deleteado com sucesso!");
        }
        return "redirect:/product";
        //return "erro";
    }
}
