package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryDto;

import java.util.List;

public class StubRemoteCategoryService implements RemoteCategoryServiceAbstraction{
    private final List<RemoteCategoryDto> db;

    private StubRemoteCategoryService(List<RemoteCategoryDto> elements) {
        this.db = elements;
    }

    public static StubRemoteCategoryService buildStubWith3Elements() {
        return new StubRemoteCategoryService(List.of(
                new RemoteCategoryDto(1, "Cat A"),
                new RemoteCategoryDto(2, "Cat B"),
                new RemoteCategoryDto(3, "Cat C")
        ));
    }

    @Override
    public List<RemoteCategoryDto> getFirstLevelCategories() {
        return db;
    }

}
