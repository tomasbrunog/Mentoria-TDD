package com.mentoria.tdd.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
public class RemoteCategoryDto implements Serializable {
    private final Integer code;
    private final String description;

    public RemoteCategoryDto(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
