package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.NewApiRemoteCategoryDto;
import com.mentoria.tdd.domain.NewApiRemoteCategoryResponseDto;

public interface NewApiRemoteCategoryWebClient {

    NewApiRemoteCategoryResponseDto findAllPaginated(Integer pageNumber);
    NewApiRemoteCategoryDto findById(Long id);
}
