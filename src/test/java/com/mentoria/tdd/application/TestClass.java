package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TestClass {

    private final CategoryService service = new CategoryService();

    @Disabled
    @Test
    void should_return_first_level_categories() {
        final var expected = buildExpectedResultSample();

        final var result = service.getFirstLevelCategories();

        assertThat(result).isEqualTo(expected);
    }

    private List<Category> buildExpectedResultSample() {
        final var categoryOne = new Category("1", "Cat A");
        final var categoryTwo = new Category("2", "Cat B");
        final var categoryThree = new Category("3", "Cat C");

        return List.of(categoryOne, categoryTwo, categoryThree);
    }

    private class CategoryService {
        public List<Category> getFirstLevelCategories() {
            throw new RuntimeException("Not implemented");
        }
    }

    @Test
    void should_fetch_first_level_remote_category_list_from_marketplace() {
        final var expected = buildWebClientExpectedResult();
        final var result = webClient.getFirstLevelCategories();

        assertThat(result).isEqualsTo(expected);
    }

    private List<RemoteCategoryDto> buildWebClientExpectedResult() {
        return null;
    }
}
