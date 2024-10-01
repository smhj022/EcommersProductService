package com.smhj.ProductService.controllers;

import com.smhj.ProductService.exceptions.CategoryNotFoundException;
import com.smhj.ProductService.exceptions.DuplicateCategoryFoundException;
import com.smhj.ProductService.models.Category;
import com.smhj.ProductService.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategory(){
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getAllCategory(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws DuplicateCategoryFoundException {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }
}
