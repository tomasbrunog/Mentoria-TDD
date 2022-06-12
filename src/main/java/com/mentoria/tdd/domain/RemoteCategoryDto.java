package com.mentoria.tdd.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class RemoteCategoryDto implements Serializable {
    private Integer code;
    private String description;
}
