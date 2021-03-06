package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import com.mentoria.tdd.domain.RemoteCategoryDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetCategoryByIdUseCaseTest {
    private static final Long ID = 56L;
    private final CategoryTranslator translator = new CategoryTranslator();

    @Test
    void should_get_category_by_id_from_marketplace() {
        final var expected = buildExpectedResultSample();
        CategoryServiceAbstraction categoryService = new CategoryService(StubRemoteCategoryService.buildWithSamples(List.of(buildRemoteResponseStub())), translator);
        final var result = categoryService.findById(ID);
        assertThat(result).isEqualTo(expected);
    }

    private Category buildExpectedResultSample() {
        final var children = (List.of(
                new Category("48", "Cat C"),
                new Category("92", "Cat D")
        ));
        return new Category("56", "Cat A", children);
    }

    private RemoteCategoryDto buildRemoteResponseStub() {
        final var subcategories = List.of(
                new RemoteCategoryDto(48, "Cat C"),
                new RemoteCategoryDto(92, "Cat D")
        );
        return new RemoteCategoryDto(56, "Cat A", subcategories);
    }
}
