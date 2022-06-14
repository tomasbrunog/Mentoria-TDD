package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RemoteCategoryResponseDto;

import java.util.ArrayList;
import java.util.List;

class RemoteCategoryService implements RemoteCategoryServiceAbstraction {
    private final RemoteCategoryWebClient remoteCategoryWebClient;

    RemoteCategoryService(RemoteCategoryWebClient remoteCategoryWebClient) {
        this.remoteCategoryWebClient = remoteCategoryWebClient;
    }

    @Override
    public List<RemoteCategoryDto> getFirstLevelCategories() {
        RemoteCategoryResponseDto response = remoteCategoryWebClient.getFirstLevelPaginated(1);
        var elements = new ArrayList<>(response.getElements());
        final double totalRecords = response.getTotalRecords();
        final double recordsPerPage = response.getElements().size();
        final var totalPages = Math.ceil(totalRecords / recordsPerPage);
        for (var i = 2; i <= totalPages; i++) {
            elements.addAll(remoteCategoryWebClient.getFirstLevelPaginated(i).getElements());
        }
        return elements;
    }
}
