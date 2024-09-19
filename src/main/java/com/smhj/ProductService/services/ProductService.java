package com.smhj.ProductService.services;

import com.smhj.ProductService.exceptions.ProductNotFoundException;
import com.smhj.ProductService.models.Category;
import com.smhj.ProductService.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product deleteProductById(Long id) throws ProductNotFoundException;

    Product addProduct(Product product);

    Product updateProductById(Long id, Product product);

    List<Category> getAllCategories();

    List<Product> getAllCategoriesByName(String categoryName);
}
