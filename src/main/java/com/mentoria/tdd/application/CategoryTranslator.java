package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import com.mentoria.tdd.domain.RemoteCategoryDto;

public class CategoryTranslator {
    public Category toEntity(RemoteCategoryDto dto) {
        return new Category(dto.getCode().toString(), dto.getDescription());
    }
}