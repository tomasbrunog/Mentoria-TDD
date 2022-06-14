package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RemoteCategoryResponseDto;

import java.util.Collections;
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

    public static StubRemoteCategoryWebClient buildWith2PagesAnd3TotalRecords() {
        final var categoryOne = new RemoteCategoryDto(1, "Cat A");
        final var categoryTwo = new RemoteCategoryDto(2, "Cat B");
        final var categoryThree = new RemoteCategoryDto(3, "Cat C");

        final var pageOne = new RemoteCategoryResponseDto(1, 3, List.of(categoryOne, categoryTwo));
        final var pageTwo = new RemoteCategoryResponseDto(2, 3, Collections.singletonList(categoryThree));

        return new StubRemoteCategoryWebClient(List.of(pageOne, pageTwo));
    }
}
