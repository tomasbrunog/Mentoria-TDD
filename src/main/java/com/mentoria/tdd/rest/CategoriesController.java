package com.mentoria.tdd.rest;

import com.mentoria.tdd.application.CategoryServiceAbstraction;
import com.mentoria.tdd.domain.RootCategoryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriesController {

    private final CategoryServiceAbstraction categoryService;

    public CategoriesController(CategoryServiceAbstraction categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    public List<RootCategoryDto> getFirstLevelCategories() {
        return categoryService.getFirstLevelCategories().stream().map(entity -> new RootCategoryDto(entity.getCodeInMarketplace(), entity.getName())).collect(Collectors.toList());
    }
}
