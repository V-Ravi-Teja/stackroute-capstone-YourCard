package com.ness.YourCard.service;

import com.ness.YourCard.DTO.CategoryDTO;


public interface CategoryService {
    public Integer addCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategory(Integer categoryId);
}
