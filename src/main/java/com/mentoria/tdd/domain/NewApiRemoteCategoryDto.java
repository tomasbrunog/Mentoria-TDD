package com.mentoria.tdd.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class NewApiRemoteCategoryDto implements Serializable {
    private Long code;
    private String description;
    private Long parentCategoryCode;
}
