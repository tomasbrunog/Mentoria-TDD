package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import com.mentoria.tdd.domain.RemoteCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class CategoryService implements CategoryServiceAbstraction {
    private final RemoteCategoryServiceAbstraction remoteCategoryService;

    CategoryService(RemoteCategoryServiceAbstraction remoteCategoryService) {
        this.remoteCategoryService = remoteCategoryService;
    }

    private static Category toEntity(RemoteCategoryDto dto) {
        return new Category(dto.getCode().toString(), dto.getDescription());
    }

    @Override
    public List<Category> getFirstLevelCategories() {
        final var remoteCategories = remoteCategoryService.getFirstLevelCategories();
        return remoteCategories.stream().map(CategoryService::toEntity).collect(Collectors.toList());
    }

    @Override
    public Category findById(Long id) {
        final var remoteCategory = remoteCategoryService.findById(id);
        var subCategories = remoteCategory.getSubcategories().stream().map(dto -> new Category(dto.getCode().toString(), dto.getDescription())).collect(Collectors.toList());
        return new Category(remoteCategory.getCode().toString(), remoteCategory.getDescription(), subCategories);
    }
}
