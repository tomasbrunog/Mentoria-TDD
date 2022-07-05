package com.mentoria.tdd.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentoria.tdd.domain.RemoteCategoryDto;
import com.mentoria.tdd.domain.RemoteCategoryResponseDto;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class FakeRemoteCategoryWebClient implements RemoteCategoryWebClient {
    private final ObjectMapper mapper = new ObjectMapper();
    private final RemoteCategoryResponseDto pageOne = mapper.readValue(new File("src/main/resources/response_categories_p1x10.json"), RemoteCategoryResponseDto.class);
    private final RemoteCategoryResponseDto pageTwo = mapper.readValue(new File("src/main/resources/response_categories_p2x10.json"), RemoteCategoryResponseDto.class);
    private final RemoteCategoryResponseDto pageThree = mapper.readValue(new File("src/main/resources/response_categories_p3x10.json"), RemoteCategoryResponseDto.class);

    public FakeRemoteCategoryWebClient() throws IOException {
    }


    @Override
    public RemoteCategoryResponseDto getFirstLevelPaginated(Integer pageNumber) {
        List<RemoteCategoryResponseDto> responses = List.of(pageOne, pageTwo, pageThree);
        return responses.get(pageNumber - 1);
    }

    @Override
    public RemoteCategoryDto findById(Long id) {
        return null;
    }
}
