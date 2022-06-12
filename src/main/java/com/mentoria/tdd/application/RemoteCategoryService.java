package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryResponseDto;

public interface RemoteCategoryService {
    RemoteCategoryResponseDto getFirstLevelPaginated(Integer pageNumber);
}
