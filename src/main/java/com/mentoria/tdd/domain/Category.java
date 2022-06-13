package com.mentoria.tdd.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Category {
    private String codeInMarketplace;
    private String name;

    public Category(String codeInMarketplace, String name) {
        this.codeInMarketplace = codeInMarketplace;
        this.name = name;
    }
}