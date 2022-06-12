package com.mentoria.tdd.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController {

    @GetMapping("/api/categories")
    public void getFirstLevelCategories() {
    }
}
