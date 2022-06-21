package com.mentoria.tdd.application;

import com.mentoria.tdd.domain.Category;
import com.mentoria.tdd.domain.NewApiRemoteCategoryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class NewApiCategoryService implements CategoryServiceAbstraction {

    private final NewApiRemoteCategoryWebClient webClient;

    public NewApiCategoryService(NewApiRemoteCategoryWebClient webClient) {

        this.webClient = webClient;
    }

    @Override
    public List<Category> getFirstLevelCategories() {
        List<NewApiRemoteCategoryDto> allRemote = fetchAllCategoriesFromMarketplace();
        List<NewApiRemoteCategoryDto> firstLevelRemote = allRemote.stream().filter(dto -> isNull(dto.getParentCategoryCode())).collect(Collectors.toList());
        return firstLevelRemote.stream().map(dto -> new Category(dto.getCode().toString(), dto.getDescription())).collect(Collectors.toList());
    }

    private List<NewApiRemoteCategoryDto> fetchAllCategoriesFromMarketplace() {

        var resultPage = webClient.findAllPaginated(1);
        var categories = new ArrayList<NewApiRemoteCategoryDto>();
        categories.addAll(resultPage.getElements());

        var totalPages = Math.ceil(resultPage.getTotalRecords().doubleValue() / categories.size());
        for (int i = 2; i <= totalPages; i++) {
            resultPage = webClient.findAllPaginated(i);
            categories.addAll(resultPage.getElements());
        }
        return categories;
    }

    @Override
    public Category findById(Long id) {
        throw new RuntimeException("not implemented");
    }
}
