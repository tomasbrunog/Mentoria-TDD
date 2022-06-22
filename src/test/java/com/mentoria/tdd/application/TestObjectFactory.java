package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import com.mentoria.tdd.domain.NewApiRemoteCategoryDto;
import com.mentoria.tdd.domain.NewApiRemoteCategoryResponseDto;
import com.mentoria.tdd.domain.RemoteCategoryDto;

import java.util.List;

public class TestObjectFactory {
    public TestObjectFactory() {
    }

    public static class ExampleA {

        public static List<Category> buildCategoryList() {
            final var categoryOne = new Category("23", "Cat B");
            final var categoryTwo = new Category("56", "Cat C");

            return List.of(categoryOne, categoryTwo);
        }

        public static List<NewApiRemoteCategoryDto> buildNewApiRemoteCategoryList() {
            return List.of(
                    new NewApiRemoteCategoryDto(43L, "Cat A", 56L),
                    new NewApiRemoteCategoryDto(23L, "Cat B", null),
                    new NewApiRemoteCategoryDto(56L, "Cat C", null),
                    new NewApiRemoteCategoryDto(92L, "Cat D", 56L)
            );
        }

        private NewApiRemoteCategoryResponseDto buildNewApiRemoteCategoryResponse() {
            final var secondLevelCategory = new NewApiRemoteCategoryDto(43L, "Cat A", 56L);
            final var firstLevelCategory = new NewApiRemoteCategoryDto(23L, "Cat B", null);

            return new NewApiRemoteCategoryResponseDto(1, 3, List.of(secondLevelCategory, firstLevelCategory));
        }

        public static Category buildCategory() {
            final var children = (List.of(
                    new Category("43", "Cat A"),
                    new Category("92", "Cat D")
            ));
            return new Category("56", "Cat C", children);
        }
    }

    public static class ExampleB {

        public static List<Category> buildCategories() {
            final var categoryOne = new Category("1", "Cat A");
            final var categoryTwo = new Category("2", "Cat B");
            final var categoryThree = new Category("3", "Cat C");

            return List.of(categoryOne, categoryTwo, categoryThree);
        }


    }
}