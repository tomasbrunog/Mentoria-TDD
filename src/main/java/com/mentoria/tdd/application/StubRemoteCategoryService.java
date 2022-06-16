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
    public static StubRemoteCategoryService buildStubWith3ElementsWithNumberNames() {
        return new StubRemoteCategoryService(List.of(
                new RemoteCategoryDto(1, "Cat 1"),
                new RemoteCategoryDto(2, "Cat 2"),
                new RemoteCategoryDto(3, "Cat 3")
        ));
    }

    public static RemoteCategoryServiceAbstraction buildWithSamples(List<RemoteCategoryDto> stubDb) {
        return new StubRemoteCategoryService(stubDb);
    }

    @Override
    public List<RemoteCategoryDto> getFirstLevelCategories() {
        return db;
    }

    @Override
    public RemoteCategoryDto findById(Long id) {
        return db.stream().filter(dto -> id.equals(dto.getCode().longValue())).findFirst().orElseThrow();
    }

}
