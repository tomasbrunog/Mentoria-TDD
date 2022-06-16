package com.mentoria.tdd;

import com.mentoria.tdd.application.RemoteCategoryWebClient;
import com.mentoria.tdd.application.StubRemoteCategoryWebClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled("acceptance tests")
@WebMvcTest
class CategoryFeatureSliceApplicationTests {

	@Autowired
	MockMvc mockMvc;

    RemoteCategoryWebClient webClient = StubRemoteCategoryWebClient.buildFirstLevelResponseStubWith2PagesAnd3TotalRecords();

    @Test
    void should_return_200_when_getting_category_list() throws Exception {
        mockMvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void should_return_first_level_categories() throws Exception {
        final var result = mockMvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(jsonPath("$", arrayWithSize(3)))
                .andExpect(jsonPath("$[0]", hasSize(2)))
                .andExpect(jsonPath("$[0]", hasProperty("codeInMarketplace")))
                .andExpect(jsonPath("$[0].codeInMarketplace", isA(String.class)))
                .andExpect(jsonPath("$[0]", hasProperty("name")))
                .andExpect(jsonPath("$[0].name", isA(String.class)))
                .andReturn();
    }
}
