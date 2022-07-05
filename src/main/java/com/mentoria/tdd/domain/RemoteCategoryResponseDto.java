package com.mentoria.tdd.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RemoteCategoryResponseDto implements Serializable {
    @JsonProperty("page_number")
    private Integer pageNumber;
    @JsonProperty("total_records")
    private Integer totalRecords;
    @JsonProperty("elements")
    private List<RemoteCategoryDto> elements;


}
