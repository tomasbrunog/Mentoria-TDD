package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.NewApiRemoteCategoryDto;
import com.mentoria.tdd.domain.NewApiRemoteCategoryResponseDto;

import java.util.HashMap;
import java.util.Map;

public class StubNewApiRemoteCategoryWebClient implements NewApiRemoteCategoryWebClient {

    private final Map<Long, NewApiRemoteCategoryResponseDto> responseDb;
    public StubNewApiRemoteCategoryWebClient(NewApiRemoteCategoryResponseDto firstStub, NewApiRemoteCategoryResponseDto secondStub) {
        responseDb = new HashMap<>();
        responseDb.put(1L, firstStub);
        responseDb.put(2L, secondStub);
    }

    @Override
    public NewApiRemoteCategoryResponseDto findAllPaginated(Integer pageNumber) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public NewApiRemoteCategoryDto findById(Long id) {
        throw new RuntimeException("not implemented");
    }
}
