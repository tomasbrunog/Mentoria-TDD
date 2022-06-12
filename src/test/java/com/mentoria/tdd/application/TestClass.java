package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RemoteCategoryResponseDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        final var remoteCategoryService = new StubRemoteCategoryService(buildRemoteServiceResponseStub());
        RemoteCategoryWebClient webClient = new RemoteCategoryWebClient(remoteCategoryService);
        final var result = webClient.getFirstLevelCategories();

        assertThat(result).isEqualTo(expected);
    }

    private Map<Integer, RemoteCategoryResponseDto> buildRemoteServiceResponseStub() {
        final var categoryOne = new RemoteCategoryDto(1, "Cat A");
        final var categoryTwo = new RemoteCategoryDto(2, "Cat B");
        final var pageOne = new RemoteCategoryResponseDto(1, 3, List.of(categoryOne, categoryTwo));


        final var categoryThree = new RemoteCategoryDto(3, "Cat 3");
        final var pageTwo = new RemoteCategoryResponseDto(2, 3, Collections.singletonList(categoryThree));

        var responseMap = new HashMap<Integer, RemoteCategoryResponseDto>();
        responseMap.put(1, pageOne);
        responseMap.put(2, pageTwo);

        return responseMap;
    }

    private List<RemoteCategoryDto> buildWebClientExpectedResult() {
        return List.of(
                new RemoteCategoryDto(1, "Cat A"),
                new RemoteCategoryDto(2, "Cat B"),
                new RemoteCategoryDto(3, "Cat C")
        );
    }

    private class RemoteCategoryWebClient {
        private final RemoteCategoryService remoteCategoryService;

        private RemoteCategoryWebClient(RemoteCategoryService remoteCategoryService) {
            this.remoteCategoryService = remoteCategoryService;
        }

        public List<RemoteCategoryDto> getFirstLevelCategories() {
            RemoteCategoryResponseDto response = remoteCategoryService.getFirstLevelPaginated(1);
            return response.getElements();
        }
    }
}
