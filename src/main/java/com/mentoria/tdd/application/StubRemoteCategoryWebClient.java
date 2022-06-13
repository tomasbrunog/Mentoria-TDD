package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryResponseDto;

import java.util.Map;

public class StubRemoteCategoryWebClient implements RemoteCategoryWebClient {

    private final Map<Integer, RemoteCategoryResponseDto> responseStubs;

    public StubRemoteCategoryWebClient(Map<Integer, RemoteCategoryResponseDto> responseStubs) {
        this.responseStubs = responseStubs;
    }

    @Override
    public RemoteCategoryResponseDto getFirstLevelPaginated(Integer pageNumber) {
        return responseStubs.get(pageNumber);
    }


}
