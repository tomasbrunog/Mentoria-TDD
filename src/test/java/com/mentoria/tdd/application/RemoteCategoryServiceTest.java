package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RemoteCategoryResponseDto;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RemoteCategoryServiceTest {

    @Test
    void should_fetch_first_level_remote_category_list_from_marketplace() {
        final var expected = buildWebClientExpectedResult();

        final var stubWebClient = new StubRemoteCategoryWebClient(buildResponseStub());

        final var service = new RemoteCategoryService(stubWebClient);

        final var result = service.getFirstLevelCategories();

        assertThat(result).isEqualTo(expected);
    }

    private Map<Integer, RemoteCategoryResponseDto> buildResponseStub() {
        final var categoryOne = new RemoteCategoryDto(1, "Cat A");
        final var categoryTwo = new RemoteCategoryDto(2, "Cat B");
        final var pageOne = new RemoteCategoryResponseDto(1, 3, List.of(categoryOne, categoryTwo));

        final var categoryThree = new RemoteCategoryDto(3, "Cat C");
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
}
