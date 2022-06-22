package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindByIdNewApiUseCaseTest {

    @Test
    void should_find_category_by_id_from_marketplace() {
        final var expected = TestObjectFactory.ExampleA.buildCategory();
        final var id = Long.parseLong(expected.getCodeInMarketplace());
        CategoryServiceAbstraction service = new NewApiCategoryService(new StubNewApiRemoteCategoryWebClient(TestObjectFactory.ExampleA.buildNewApiRemoteCategoryList()));

        final var result = service.findById(id);

        assertThat(result).isEqualTo(expected);
    }
}
