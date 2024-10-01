package com.smhj.ProductService.controllers;

import com.smhj.ProductService.exceptions.ProductNotFoundException;
import com.smhj.ProductService.models.Product;
import com.smhj.ProductService.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean() // This is going to be mocked object
    @Qualifier("SelfProductService")
    private ProductService productService;

    @Test
    void validGetProductByIdTest() throws ProductNotFoundException {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Iphone 17");
        product.setPrice(150000L);

        // mocked the product value
        when(productService.getProductById(1L)).thenReturn(product);

        Product actualProduct = productController.getProductById(1L).getBody();

        assertEquals(product, actualProduct);
    }

    @Test
    void testInValidGetProductId() throws ProductNotFoundException {
        when(productService.getProductById(100L)).thenThrow(new ProductNotFoundException(100L, "Product not found"));
        assertThrows(ProductNotFoundException.class, () -> productController.getProductById(100L).getBody());
    }

    @Test
    void testGetAllProduct(){

        List<Product> expectedProductList = new ArrayList<>();

        Product p1 = new Product();
        p1.setId(1L);
        p1.setTitle("Iphone 13 Pro");

        Product p2 = new Product();
        p2.setId(2L);
        p2.setTitle("Iphone 14 Pro");

        Product p3 = new Product();
        p3.setId(3L);
        p3.setTitle("Iphone 14 Pro");

        expectedProductList.add(p1);
        expectedProductList.add(p2);
        expectedProductList.add(p3);

        when(productService.getAllProducts()).thenReturn(expectedProductList);

        ResponseEntity<List<Product>> actualProductList = productController.getAllProducts();

        assertIterableEquals(expectedProductList, actualProductList.getBody());
    }
}