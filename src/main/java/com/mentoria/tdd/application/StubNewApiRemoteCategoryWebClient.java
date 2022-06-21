package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.NewApiRemoteCategoryDto;
import com.mentoria.tdd.domain.NewApiRemoteCategoryResponseDto;

import java.util.HashMap;
import java.util.Map;

public class StubNewApiRemoteCategoryWebClient implements NewApiRemoteCategoryWebClient {

    private final Map<Integer, NewApiRemoteCategoryResponseDto> responseDb;
    public StubNewApiRemoteCategoryWebClient(NewApiRemoteCategoryResponseDto firstStub, NewApiRemoteCategoryResponseDto secondStub) {
        responseDb = new HashMap<>();
        responseDb.put(1, firstStub);
        responseDb.put(2, secondStub);
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
