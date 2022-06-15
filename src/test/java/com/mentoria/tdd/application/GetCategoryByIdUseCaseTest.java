package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetCategoryByIdUseCaseTest {
    private static final Long ID = 56L;

    @Test
    void should_get_category_by_id_from_marketplace() {
        final var expected = buildExpectedResultSample();
        final var result = categoryService.findById(ID);
        assertThat(result.getCodeInMarketplace()).isAString();
        assertThat(result.getName()).isAString();
        assertThat(result.getChildren()).isArrayOfSize(2);
        assertThat(result).isEqualTo(expected);


    }

    private Category buildExpectedResultSample() {
        final var category = new Category("56", "Cat A");
        category.setChildren(List.of(
                new Category("48", "Cat C"),
                new Category("92", "Cat D")
        ));
        return category;
    }
}
