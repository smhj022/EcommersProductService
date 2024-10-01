package com.smhj.ProductService.services;

import com.smhj.ProductService.exceptions.CategoryNotFoundException;
import com.smhj.ProductService.exceptions.DuplicateCategoryFoundException;
import com.smhj.ProductService.exceptions.ProductNotFoundException;
import com.smhj.ProductService.models.Category;
import com.smhj.ProductService.models.Product;
import com.smhj.ProductService.repos.CategoryRepo;
import com.smhj.ProductService.repos.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public ProductServiceImpl(ProductRepo productRepo, CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    public Product getProductById(Long id) throws ProductNotFoundException {
        return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id, "Product not found with id " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public Product deleteProductById(Long id) throws ProductNotFoundException {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id, "Invalid product id " + id));
        productRepo.delete(product);
        return product;
    }

    @Override
    public Product addProduct(Product product) throws CategoryNotFoundException {
        Category managedCategory = categoryRepo.findById(product.getCategory().getId())
                .orElseThrow(() -> new CategoryNotFoundException(product.getCategory().getId(), "Category not found"));
        product.setCategory(managedCategory);
        return productRepo.save(product);
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        //check if product is available or not
        Optional<Product> productObj = productRepo.findById(id);

        if(productObj.isPresent()){
            // check if category is available or not
            Optional<Category> categoryOptional = categoryRepo.findByName(product.getCategory().getName());
            if(categoryOptional.isPresent()){
                product.setCategory(categoryOptional.get());
            } else {
                Category category = categoryRepo.save(product.getCategory());
                product.setCategory(category);
            }
            product.setId(id);
            productRepo.save(product);
            return product;
        }
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(Long id) throws CategoryNotFoundException {
        Category managedCategory = categoryRepo.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id , "Category not found"));

        return productRepo.findByCategory(managedCategory);
    }
}
