package com.mentoria.tdd.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class RemoteCategoryDto implements Serializable {
    private Integer code;
    private String description;
    private List<RemoteCategoryDto> subcategories;

    public RemoteCategoryDto(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public RemoteCategoryDto(Integer code, String description, List<RemoteCategoryDto> subcategories) {
        this.code = code;
        this.description = description;
        this.subcategories = subcategories;
    }
}
