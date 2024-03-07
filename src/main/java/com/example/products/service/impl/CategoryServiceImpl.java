package com.example.products.service.impl;

import com.example.products.model.Category;
import com.example.products.model.exceptions.InvalidCategoryIdException;
import com.example.products.repository.CategoryRepository;
import com.example.products.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(InvalidCategoryIdException::new);
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(String name) {
        Category category = new Category(name);
        return categoryRepository.save(category);
    }
}
