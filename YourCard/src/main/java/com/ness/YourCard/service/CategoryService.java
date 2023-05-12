package com.ness.YourCard.service;

import com.ness.YourCard.DTO.CategoryDTO;


public interface CategoryService {
    public Integer addCategory(CategoryDTO categoryDTO);

    public CategoryDTO getCategory(Integer categoryId);

    public void updateCategory(Integer categoryId, CategoryDTO categoryDTO);

    public void deleteCategory(Integer categoryId);
}
