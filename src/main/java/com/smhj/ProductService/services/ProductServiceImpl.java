package com.smhj.ProductService.services;

import com.smhj.ProductService.models.Category;
import com.smhj.ProductService.models.Product;
import com.smhj.ProductService.repos.CategoryRepo;
import com.smhj.ProductService.repos.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public ProductServiceImpl(ProductRepo productRepo, CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Long id) {
        /*
        Product product=  productRepo.findById(id);
        Category category = product.getCategory();

        if we don't use optional category line will throw null pointer exception

        Optional -> it will force you to check if product exist or not at compile time
                    to check if product is available or not;
        * */
        Optional<Product> product = productRepo.findById(id);
//        if(product.isPresent()) {
//            Category category = product.get().getCategory();
//        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public Product deleteProductById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isPresent()) {
            productRepo.delete(product.get());
            return product.get();
        }
        return null;
    }

    @Override
    public Product addProduct(Product product) {
//        Optional<Category> categoryOptional = categoryRepo.findByName(product.getCategory().getName());
//        if(categoryOptional.isPresent()){
//            product.setCategory(categoryOptional.get());
//        } else {
//            Category category = categoryRepo.save(product.getCategory());
//            product.setCategory(category);
//        }
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
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public List<Product> getAllCategoriesByName(String categoryName) {
        Optional<Category> category = categoryRepo.findByName(categoryName);
        if(category.isPresent()){
            return productRepo.findByCategoryName(categoryName).get();
        }
        return null;
    }
}
