package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindByIdNewApiUseCaseTest {
    private static final Long ID = 1L;

    @Test
    void should_find_category_by_id_from_marketplace() {
        CategoryServiceAbstraction service = new NewApiCategoryService(new StubNewApiRemoteCategoryWebClient());
        Category result = service.findById(ID);
        assertThat(result).isEqualTo(TestObjectFactory.ExampleA.buildCategory());
    }
}
