package com.smhj.ProductService.services;

import com.smhj.ProductService.dtos.FakeStoreProductDto;
import com.smhj.ProductService.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
public class ProductServiceImpl implements ProductService{

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void addProduct() {

    }

    @Override
    public void updateProductById() {

    }
}
