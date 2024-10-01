package com.smhj.ProductService.services;

import com.smhj.ProductService.exceptions.CategoryNotFoundException;
import com.smhj.ProductService.exceptions.DuplicateCategoryFoundException;
import com.smhj.ProductService.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category getCategoryById(Long id) throws CategoryNotFoundException;
    List<Category> getAllCategory();
    Category addCategory(Category category) throws DuplicateCategoryFoundException;
}
