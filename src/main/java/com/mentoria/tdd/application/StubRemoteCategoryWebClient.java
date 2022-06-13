package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryResponseDto;

import java.util.List;

public class StubRemoteCategoryWebClient implements RemoteCategoryWebClient {

    private final List<RemoteCategoryResponseDto> responseStubs;

    public StubRemoteCategoryWebClient(List<RemoteCategoryResponseDto> responseStubs) {
        this.responseStubs = responseStubs;
    }

    @Override
    public RemoteCategoryResponseDto getFirstLevelPaginated(Integer pageNumber) {
        return responseStubs.get(pageNumber - 1);
    }


}
