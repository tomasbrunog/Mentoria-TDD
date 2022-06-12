package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryResponseDto;

import java.util.Map;

public class StubRemoteCategoryService implements RemoteCategoryService {

    private final Map<Integer, RemoteCategoryResponseDto> responseStubs;

    public StubRemoteCategoryService(Map<Integer, RemoteCategoryResponseDto> responseStubs) {
        this.responseStubs = responseStubs;
    }

    @Override
    public RemoteCategoryResponseDto getFirstLevelPaginated(Integer pageNumber) {
        return responseStubs.get(pageNumber);
    }


}
