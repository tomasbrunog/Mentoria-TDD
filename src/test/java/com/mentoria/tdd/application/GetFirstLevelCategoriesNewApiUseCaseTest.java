package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import com.mentoria.tdd.domain.NewApiRemoteCategoryDto;
import com.mentoria.tdd.domain.NewApiRemoteCategoryResponseDto;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetFirstLevelCategoriesNewApiUseCaseTest {
    @Test
    void should_get_first_level_categories_from_marketplace() {
        CategoryServiceAbstraction service = new NewApiCategoryService(new StubNewApiRemoteCategoryWebClient(buildFirstPageStub(), buildSecondPageStub()));
        List<Category> result = service.getFirstLevelCategories();
        assertThat(result).isEqualTo(buildExpectedResult());
    }

    private NewApiRemoteCategoryResponseDto buildFirstPageStub() {
        final var secondLevelCategory = new NewApiRemoteCategoryDto(43L, "Cat A", 56L);
        final var firstLevelCategory = new NewApiRemoteCategoryDto(23L, "Cat B", null);

        return new NewApiRemoteCategoryResponseDto(1, 3, List.of(secondLevelCategory, firstLevelCategory));
    }

    private NewApiRemoteCategoryResponseDto buildSecondPageStub() {
        final var firstLevelCategory = new NewApiRemoteCategoryDto(56L, "Cat C", null);

        return new NewApiRemoteCategoryResponseDto(2, 3, Collections.singletonList(firstLevelCategory));
    }

    private List<Category> buildExpectedResult() {
        final var categoryOne = new Category("23", "Cat B");
        final var categoryTwo = new Category("56", "Cat C");

        return List.of(categoryOne, categoryTwo);
    }
}
