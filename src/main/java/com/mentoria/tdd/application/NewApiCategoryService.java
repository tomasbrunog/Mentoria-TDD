package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;

import java.util.List;

public class NewApiCategoryService implements CategoryServiceAbstraction {

    private final NewApiRemoteCategoryWebClient webClient;

    public NewApiCategoryService(NewApiRemoteCategoryWebClient webClient) {

        this.webClient = webClient;
    }

    @Override
    public List<Category> getFirstLevelCategories() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public Category findById(Long id) {
        throw new RuntimeException("not implemented");
    }
}
