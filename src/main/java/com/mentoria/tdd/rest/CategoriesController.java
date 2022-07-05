package com.mentoria.tdd.rest;

import com.mentoria.tdd.application.CategoryServiceAbstraction;
import com.mentoria.tdd.application.CategoryTranslator;
import com.mentoria.tdd.domain.RootCategoryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriesController {

    private final CategoryServiceAbstraction categoryService;
    private final CategoryTranslator translator;

    public CategoriesController(CategoryServiceAbstraction categoryService, CategoryTranslator translator) {
        this.categoryService = categoryService;
        this.translator = translator;
    }

    @GetMapping("/api/categories")
    public List<RootCategoryDto> getFirstLevelCategories() {
        return categoryService.getFirstLevelCategories().stream().map(translator::toDto).collect(Collectors.toList());
    }
}
