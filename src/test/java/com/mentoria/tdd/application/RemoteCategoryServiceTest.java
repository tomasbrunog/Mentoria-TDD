package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RemoteCategoryServiceTest {

    @Test
    void should_fetch_first_level_categories_from_marketplace() {
        final var expected = buildExpectedFirstLevelCategoriesSample();
        final var stubWebClient = StubRemoteCategoryWebClient.buildFirstLevelResponseStubWith2PagesAnd3TotalRecords();
        final var service = new RemoteCategoryService(stubWebClient);

        final var result = service.getFirstLevelCategories();

        assertThat(result).isEqualTo(expected);
    }

    private List<RemoteCategoryDto> buildExpectedFirstLevelCategoriesSample() {
        return List.of(
                new RemoteCategoryDto(1, "Cat A"),
                new RemoteCategoryDto(2, "Cat B"),
                new RemoteCategoryDto(3, "Cat C")
        );
    }
}
