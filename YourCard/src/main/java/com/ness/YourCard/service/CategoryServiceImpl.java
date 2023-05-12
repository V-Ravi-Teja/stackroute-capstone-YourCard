package com.ness.YourCard.service;

import com.ness.YourCard.DTO.CategoryDTO;
import com.ness.YourCard.Exception.NotFoundException;
import com.ness.YourCard.entity.Category;
import com.ness.YourCard.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Integer addCategory(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        categoryRepository.save(category);

        return category.getCategoryId();
    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {

        Optional<Category> optional = categoryRepository.findById(categoryId);
        Category category = optional.get();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setCategoryName(category.getCategoryName());
        return categoryDTO;

    }

    @Override
    public void updateCategory(Integer categoryId, CategoryDTO categoryDTO) {

        Optional<Category> optional = categoryRepository.findById(categoryId);
        Category category = optional.get();
        category.setCategoryId(categoryId);
        category.setCategoryName(categoryDTO.getCategoryName());
        categoryRepository.save(category);

    }

    @Override
    public void deleteCategory(Integer categoryId) {

        Optional<Category> optional = categoryRepository.findById(categoryId);
        Category category = optional.get();
        categoryRepository.delete(category);

    }
}
