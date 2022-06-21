package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.NewApiRemoteCategoryDto;
import com.mentoria.tdd.domain.NewApiRemoteCategoryResponseDto;

import java.util.HashMap;
import java.util.Map;

public class StubNewApiRemoteCategoryWebClient implements NewApiRemoteCategoryWebClient {

    private final Map<Integer, NewApiRemoteCategoryResponseDto> responseDb = new HashMap<>();
    public StubNewApiRemoteCategoryWebClient(NewApiRemoteCategoryResponseDto... stubs) {
        for (final var stub : stubs) {
            responseDb.put(stub.getPageNumber(), stub);
        }
    }

    @Override
    public NewApiRemoteCategoryResponseDto findAllPaginated(Integer pageNumber) {
        return responseDb.get(pageNumber);
    }

    @Override
    public NewApiRemoteCategoryDto findById(Long id) {
        throw new RuntimeException("not implemented");
    }
}
