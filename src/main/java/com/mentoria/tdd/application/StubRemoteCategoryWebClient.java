package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RemoteCategoryResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StubRemoteCategoryWebClient implements RemoteCategoryWebClient {

    private List<RemoteCategoryResponseDto> firstLevelCategoryResponseStubs;
    @Setter(AccessLevel.PRIVATE)
    private List<RemoteCategoryDto> categoryDb;

    private StubRemoteCategoryWebClient(List<RemoteCategoryResponseDto> responseStubs) {
        this.firstLevelCategoryResponseStubs = responseStubs;
    }

    @Override
    public RemoteCategoryResponseDto getFirstLevelPaginated(Integer pageNumber) {
        return firstLevelCategoryResponseStubs.get(pageNumber - 1);
    }

    public static StubRemoteCategoryWebClient buildFirstLevelResponseStubWith2PagesAnd3TotalRecords() {
        final var categoryOne = new RemoteCategoryDto(1, "Cat A");
        final var categoryTwo = new RemoteCategoryDto(2, "Cat B");
        final var categoryThree = new RemoteCategoryDto(3, "Cat C");

        final var pageOne = new RemoteCategoryResponseDto(1, 3, List.of(categoryOne, categoryTwo));
        final var pageTwo = new RemoteCategoryResponseDto(2, 3, Collections.singletonList(categoryThree));

        return new StubRemoteCategoryWebClient(List.of(pageOne, pageTwo));
    }

    public static StubRemoteCategoryWebClient buildWithStubCategoryDb(List<RemoteCategoryDto> categoryDb) {
        final var stub = new StubRemoteCategoryWebClient();
        stub.setCategoryDb(categoryDb);
        return stub;
    }
}
