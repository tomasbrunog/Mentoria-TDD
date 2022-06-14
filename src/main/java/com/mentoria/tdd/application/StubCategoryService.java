package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class StubCategoryService implements CategoryServiceAbstraction {
    private final List<Category> db = new ArrayList<>();

    @Override
    public List<Category> getFirstLevelCategories() {
        return db;
    }


    public static class Builder {
        private final StubCategoryService service = new StubCategoryService();

        public Builder withElements(int quantity) {
            for (int i = 1; i <= quantity; i++) {
                service.db.add(new Category(Integer.toString(i), String.format("Cat %s", i)));
            }
            return this;
        }

        public StubCategoryService result() {
            return service;
        }

    }

}
