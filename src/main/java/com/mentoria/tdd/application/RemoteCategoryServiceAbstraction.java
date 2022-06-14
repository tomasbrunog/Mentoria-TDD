package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryDto;

import java.util.List;

public interface RemoteCategoryServiceAbstraction {
    List<RemoteCategoryDto> getFirstLevelCategories();
}
