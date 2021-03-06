package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class CategoryService implements CategoryServiceAbstraction {
    private final RemoteCategoryServiceAbstraction remoteCategoryService;
    private final CategoryTranslator translator;

    CategoryService(RemoteCategoryServiceAbstraction remoteCategoryService, CategoryTranslator translator) {
        this.remoteCategoryService = remoteCategoryService;
        this.translator = translator;
    }

    @Override
    public List<Category> getFirstLevelCategories() {
        final var remoteCategories = remoteCategoryService.getFirstLevelCategories();
        return remoteCategories.stream().map(translator::toEntity).collect(Collectors.toList());
    }

    @Override
    public Category findById(Long id) {
        final var remoteCategory = remoteCategoryService.findById(id);
        var subCategories = remoteCategory.getSubcategories().stream().map(translator::toEntity).collect(Collectors.toList());
        return new Category(remoteCategory.getCode().toString(), remoteCategory.getDescription(), subCategories);
    }
}
