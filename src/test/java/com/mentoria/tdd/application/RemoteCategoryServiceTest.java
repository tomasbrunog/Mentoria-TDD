package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RemoteCategoryResponseDto;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RemoteCategoryServiceTest {

    @Test
    void should_fetch_first_level_categories_from_marketplace() {
        final var expected = buildWebClientExpectedResult();
        final var stubWebClient = new StubRemoteCategoryWebClient(buildResponseStubs());
        final var service = new RemoteCategoryService(stubWebClient);

        final var result = service.getFirstLevelCategories();

        assertThat(result).isEqualTo(expected);
    }

    private List<RemoteCategoryDto> buildWebClientExpectedResult() {
        return List.of(
                new RemoteCategoryDto(1, "Cat A"),
                new RemoteCategoryDto(2, "Cat B"),
                new RemoteCategoryDto(3, "Cat C")
        );
    }

    private List<RemoteCategoryResponseDto> buildResponseStubs() {
        final var categoryOne = new RemoteCategoryDto(1, "Cat A");
        final var categoryTwo = new RemoteCategoryDto(2, "Cat B");
        final var categoryThree = new RemoteCategoryDto(3, "Cat C");

        final var pageOne = new RemoteCategoryResponseDto(1, 3, List.of(categoryOne, categoryTwo));
        final var pageTwo = new RemoteCategoryResponseDto(2, 3, Collections.singletonList(categoryThree));

        return List.of(pageOne, pageTwo);
    }

}
