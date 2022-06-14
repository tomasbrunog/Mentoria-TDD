package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;

import java.util.List;
import java.util.stream.Collectors;

class CategoryService implements CategoryServiceAbstraction {
    private final RemoteCategoryServiceAbstraction remoteCategoryService;

    CategoryService(RemoteCategoryServiceAbstraction remoteCategoryService) {
        this.remoteCategoryService = remoteCategoryService;
    }

    @Override
    public List<Category> getFirstLevelCategories() {
        final var remoteCategories = remoteCategoryService.getFirstLevelCategories();
        return remoteCategories.stream().map(dto -> new Category(dto.getCode().toString(), dto.getDescription())).collect(Collectors.toList());
    }
}
