package com.mentoria.tdd.rest;

import com.mentoria.tdd.application.CategoryServiceAbstraction;
import com.mentoria.tdd.domain.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    private final CategoryServiceAbstraction categoryService;

    public CategoriesController(CategoryServiceAbstraction categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    public List<Category> getFirstLevelCategories() {
        return categoryService.getFirstLevelCategories();
    }
}
