package com.mentoria.tdd.domain;

import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class Category {
    private final String codeInMarketplace;
    private final String name;
    private List<Category> children;

    public Category(String codeInMarketplace, String name) {
        this.codeInMarketplace = codeInMarketplace;
        this.name = name;
    }

    public Category(String codeInMarketplace, String name, List<Category> children) {
        this.codeInMarketplace = codeInMarketplace;
        this.name = name;
        this.children = children;
    }
}