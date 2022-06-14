package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CategoryServiceTest {

    private final CategoryService service = new CategoryService(StubRemoteCategoryService.buildStubWith3Elements());

    @Test
    void should_return_first_level_categories() {
        final var expected = buildExpectedResultSample();

        final var result = service.getFirstLevelCategories();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void should_return_first_level_categories_using_stub() {
        final var expected = new StubCategoryService.Builder().withElements(3).result().getFirstLevelCategories();

        final CategoryService service = new CategoryService(StubRemoteCategoryService.buildStubWith3ElementsWithNumberNames());

        final var result = service.getFirstLevelCategories();

        assertThat(result).isEqualTo(expected);
    }

    private List<Category> buildExpectedResultSample() {
        final var categoryOne = new Category("1", "Cat A");
        final var categoryTwo = new Category("2", "Cat B");
        final var categoryThree = new Category("3", "Cat C");

        return List.of(categoryOne, categoryTwo, categoryThree);
    }
}
