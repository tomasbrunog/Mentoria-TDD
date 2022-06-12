package com.mentoria.tdd.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class RemoteCategoryResponseDto implements Serializable {
    private final Integer pageNumber;
    private final Integer totalRecords;
    private final List<RemoteCategoryDto> elements;

    public RemoteCategoryResponseDto(Integer pageNumber, Integer totalRecords, List<RemoteCategoryDto> elements) {
        this.pageNumber = pageNumber;
        this.totalRecords = totalRecords;
        this.elements = elements;
    }
}
