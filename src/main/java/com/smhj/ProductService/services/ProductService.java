package com.smhj.ProductService.services;

import com.smhj.ProductService.dtos.FakeStoreProductDto;
import com.smhj.ProductService.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProductById();

    void addProduct();

    void updateProductById();
}
