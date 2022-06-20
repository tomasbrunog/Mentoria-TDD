package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RemoteCategoryResponseDto;

public interface RemoteCategoryWebClient {
    RemoteCategoryResponseDto getFirstLevelPaginated(Integer pageNumber);
    RemoteCategoryDto findById(Long id);
}
