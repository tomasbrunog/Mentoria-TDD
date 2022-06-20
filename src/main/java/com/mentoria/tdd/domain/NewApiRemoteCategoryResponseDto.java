package com.mentoria.tdd.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class NewApiRemoteCategoryResponseDto {
    private Integer pageNumber;
    private Integer totalRecords;
    private List<NewApiRemoteCategoryDto> elements;
}
