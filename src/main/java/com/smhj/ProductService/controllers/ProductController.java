package com.smhj.ProductService.controllers;

import com.smhj.ProductService.models.Product;
import com.smhj.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    //  Constructor injection ->  Best Practice
    @Autowired
    public ProductController(@Qualifier("FakeProductService") ProductService productService){
        this.productService = productService;
    }


//    @Autowired -> setter based injection
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }

    // request path
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

//    public String getProductByCategory(String category){
//
//    }


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
