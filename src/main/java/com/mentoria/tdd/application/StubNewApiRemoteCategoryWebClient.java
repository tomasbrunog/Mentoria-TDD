package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.NewApiRemoteCategoryDto;
import com.mentoria.tdd.domain.NewApiRemoteCategoryResponseDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class StubNewApiRemoteCategoryWebClient implements NewApiRemoteCategoryWebClient {

    private final Map<Integer, NewApiRemoteCategoryResponseDto> responseDb = new HashMap<>();
    private List<NewApiRemoteCategoryDto> db = new ArrayList<>();

    public StubNewApiRemoteCategoryWebClient(NewApiRemoteCategoryResponseDto... stubs) {
        for (final var stub : stubs) {
            responseDb.put(stub.getPageNumber(), stub);
        }
    }

    public StubNewApiRemoteCategoryWebClient(List<NewApiRemoteCategoryDto> db) {
        this.db = db;
    }

    @Override
    public NewApiRemoteCategoryResponseDto findAllPaginated(Integer pageNumber) {
        return responseDb.get(pageNumber);
    }

    @Override
    public NewApiRemoteCategoryDto findById(Long id) {
        return db.stream().filter(dto -> dto.getCode().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public List<NewApiRemoteCategoryDto> findAllByParentId(Long id) {
        return db.stream().filter(dto -> nonNull(dto.getParentCategoryCode())).filter(dto -> dto.getParentCategoryCode().equals(id)).collect(Collectors.toList());
    }
}
