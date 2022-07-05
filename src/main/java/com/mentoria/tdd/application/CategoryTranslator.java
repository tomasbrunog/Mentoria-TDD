package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RootCategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryTranslator {
    public Category toEntity(RemoteCategoryDto dto) {
        return new Category(dto.getCode().toString(), dto.getDescription());
    }

    public RootCategoryDto toDto(Category entity) {
        return new RootCategoryDto(entity.getCodeInMarketplace(), entity.getName());
    }
}