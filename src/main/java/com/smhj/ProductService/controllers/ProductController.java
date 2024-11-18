package com.smhj.ProductService.controllers;

import com.smhj.ProductService.commons.AuthCommon;
import com.smhj.ProductService.dtos.UserDto;
import com.smhj.ProductService.exceptions.CategoryNotFoundException;
import com.smhj.ProductService.exceptions.ProductNotFoundException;
import com.smhj.ProductService.models.Product;
import com.smhj.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


// RestController vs Controller -> RestController do additional validation(compile time) which
// are applicable on rest based controller

//@Controller: Indicates that a particular class serves as a controller in an MVC application.

//@RestController: A combination of @Controller and @ResponseBody. It indicates that
// the class is a controller where every method returns a domain object instead of a view

@RestController
@RequestMapping("/products") // common path
public class ProductController {

    //@Autowired -> field injection
    // constructor injection
    private final ProductService productService;
    private final AuthCommon authCommon;


    //  Constructor injection ->  Best Practice
    @Autowired
    public ProductController(@Qualifier("SelfProductService") ProductService productService,
                             AuthCommon authCommon){
        this.productService = productService;
        this.authCommon = authCommon;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable("id") Long id) throws ProductNotFoundException {

//        UserDto userDto = authCommon.validateToken(token);
//        if(userDto == null){
//            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
//        }
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
            throws CategoryNotFoundException {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product)
            throws CategoryNotFoundException, ProductNotFoundException {
        return productService.updateProductById(id, product);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam Long categoryId)
            throws CategoryNotFoundException {
        return new ResponseEntity<>(productService.getProductsByCategory(categoryId), HttpStatus.OK);
    }
}

/*
* 1. GetProductById(Id)
* 2. GetAllProducts
* 3. UpdateProductById()
* 4. DeleteProduct(id)
* 5. AddProduct()
* */


// Types of injection
/*
 * 1. Constructor injection
 * 2. Field injection -> Not recommended -> too many autowired
 * 3. Setter injection
 */
