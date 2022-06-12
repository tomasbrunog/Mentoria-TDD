package com.mentoria.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CategoryFeatureSliceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void should_return_200_when_getting_gategory_list() throws Exception {
		mockMvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
