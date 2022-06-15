package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;

import java.util.List;

public interface CategoryServiceAbstraction {
    List<Category> getFirstLevelCategories();

    Category findById(Long id);
}
