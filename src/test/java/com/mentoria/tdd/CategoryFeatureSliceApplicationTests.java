package com.mentoria.tdd;

import com.mentoria.tdd.application.RemoteCategoryWebClient;
import com.mentoria.tdd.application.TestObjectFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CategoryFeatureSliceApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RemoteCategoryWebClient webClient;

    @BeforeEach
    void setUp() {
        TestObjectFactory.ExampleB.RemoteCategoryResponseDto responseStubs = new TestObjectFactory.ExampleB.RemoteCategoryResponseDto();
        when(webClient.getFirstLevelPaginated(1)).thenReturn(responseStubs.buildPageOne());
        when(webClient.getFirstLevelPaginated(2)).thenReturn(responseStubs.buildPageTwo());
    }

    @Test
    void should_return_200_when_getting_category_list() throws Exception {
        mockMvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void should_get_root_categories() throws Exception {
        final var result = mockMvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0]", aMapWithSize(2)))
                .andExpect(jsonPath("$[0]", hasKey("codeInMarketplace")))
                .andExpect(jsonPath("$[0].codeInMarketplace", isA(String.class)))
                .andExpect(jsonPath("$[0]", hasKey("name")))
                .andExpect(jsonPath("$[0].name", isA(String.class)))
                .andReturn();
    }
}
