package com.smhj.ProductService.services;

import com.smhj.ProductService.dtos.FakeStoreProductDto;
import com.smhj.ProductService.exceptions.ProductNotFoundException;
import com.smhj.ProductService.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product deleteProductById(Long id);

    Product addProduct(Product product);

    void updateProductById();
}
