package com.ness.YourCard.controller;

import com.ness.YourCard.DTO.CategoryDTO;
import com.ness.YourCard.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/yourcard")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/CreateCategory")
    public String addCategory(@RequestBody CategoryDTO categoryDTO){
        Integer categoryId = categoryService.addCategory(categoryDTO);
        return "Category with id: " + categoryId + " added successfully.";
    }

    @GetMapping(value = "/GetCategory/{categoryId}")
    public CategoryDTO getCategory(@PathVariable Integer categoryId) {
        CategoryDTO categorydto = categoryService.getCategory(categoryId);
        return categorydto;
    }
}
