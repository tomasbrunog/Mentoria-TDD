package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RemoteCategoryResponseDto;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CategoryServiceTest {

    private final CategoryService service = new CategoryService(new RemoteCategoryService(new StubRemoteCategoryWebClient(buildResponseStubs())));

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

    private List<RemoteCategoryResponseDto> buildResponseStubs() {
        final var categoryOne = new RemoteCategoryDto(1, "Cat A");
        final var categoryTwo = new RemoteCategoryDto(2, "Cat B");
        final var categoryThree = new RemoteCategoryDto(3, "Cat C");

        final var pageOne = new RemoteCategoryResponseDto(1, 3, List.of(categoryOne, categoryTwo));
        final var pageTwo = new RemoteCategoryResponseDto(2, 3, Collections.singletonList(categoryThree));

        return List.of(pageOne, pageTwo);
    }

}
