package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class StubCategoryService implements CategoryServiceAbstraction {
    private final List<Category> db;

    private StubCategoryService(List<Category> categories) {
        this.db = categories;
    }

    @Override
    public List<Category> getFirstLevelCategories() {
        return db;
    }

    public static class Builder {
        private static final List<Category> db = new ArrayList<>();

        public Builder withElements(int quantity) {
            for (int i = 1; i <= quantity; i++) {
                db.add(new Category(Integer.toString(i), String.format("Cat %s", i)));
            }
            return this;
        }

        public StubCategoryService result() {
            return new StubCategoryService(db);
        }
    }
}
