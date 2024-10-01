package com.smhj.ProductService.services;

import com.smhj.ProductService.exceptions.CategoryNotFoundException;
import com.smhj.ProductService.exceptions.DuplicateCategoryFoundException;
import com.smhj.ProductService.models.Category;
import com.smhj.ProductService.repos.CategoryRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {
        return categoryRepo.findById(id).orElseThrow(() -> new CategoryNotFoundException(id,
                "Category with id " + id  + " is not available"));
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Category addCategory(Category category) throws DuplicateCategoryFoundException {
        try {
            return categoryRepo.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateCategoryFoundException(category.getName());
        }
    }
}
