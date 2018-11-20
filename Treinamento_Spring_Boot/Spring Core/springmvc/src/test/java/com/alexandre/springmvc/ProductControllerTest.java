package com.alexandre.springmvc;

import com.alexandre.springmvc.controllers.ProductController;
import com.alexandre.springmvc.domains.Product;
import com.alexandre.springmvc.services.product.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testList() throws Exception{
        List<Product> products = new ArrayList<>();
        products.add(new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg"));
        products.add(new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg"));
        products.add(new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg"));
        products.add(new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg"));
        products.add(new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg"));

        when(productService.listaAllProducts()).thenReturn((List) products);

        mockMvc.perform(get("/product"))
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attribute("products", hasSize(5)));
    }

    @Test
    public void testStatusList() throws Exception{
        List<Product> products = new ArrayList<>();
        products.add(new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg"));
        products.add(new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg"));

        when(productService.listaAllProducts()).thenReturn((List) products);

//        URL normal is product
        mockMvc.perform(get("/products"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testId() throws Exception{
        Integer id = 1;

        when(productService.getById(id)).thenReturn(new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg"));

//        URL normal is product
        mockMvc.perform(get("/product/" + id))
                .andExpect(status().isOk())
                .andExpect(view().name("product"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void testNewProduct() throws Exception {
        Integer id = 1;

        verifyZeroInteractions(productService);

        mockMvc.perform(get("/product/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("newproduct"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        Integer id = 1;

        mockMvc.perform(get("/product/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product"));

        verify(productService, times(1)).delete(1);
    }

    @Test
    public void testSaveOrUpdateProduct() throws Exception {
        Integer id = 1;
        String description = "description";
        BigDecimal price = new BigDecimal("12.00");
        String imageUrl = "http://www.example.com.br/image.jpg";

        Product productReturn = new Product("product 5", new BigDecimal("500"), "http://example.product5.jpg");
        productReturn.setId(id);
        productReturn.setDescription(description);
        productReturn.setPrice(price);
        productReturn.setImageUrl(imageUrl);

        when(productService.saveOrUpdate((Product) any())).thenReturn(productReturn);

        mockMvc.perform(post("/product")
            .param("id", "1")
                .param("description", "description")
                .param("price", "12.00")
                .param("imageUrl", "http://www.example.com.br/image.jpg")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product/1"))
                .andExpect(model().attribute("product", instanceOf(Product.class)))
                .andExpect(model().attribute("product", hasProperty("id", is(id))))
                .andExpect(model().attribute("product", hasProperty("description", is(description))))
                .andExpect(model().attribute("product", hasProperty("price", is(price))))
                .andExpect(model().attribute("product", hasProperty("imageUrl", is(imageUrl))));

        ArgumentCaptor<Product> boundProduct = ArgumentCaptor.forClass(Product.class);
        verify(productService).saveOrUpdate(boundProduct.capture());

        assertEquals(id, boundProduct.getValue().getId());
        assertEquals(description, boundProduct.getValue().getDescription());
        assertEquals(price, boundProduct.getValue().getPrice());
        assertEquals(imageUrl, boundProduct.getValue().getImageUrl());
    }




}
