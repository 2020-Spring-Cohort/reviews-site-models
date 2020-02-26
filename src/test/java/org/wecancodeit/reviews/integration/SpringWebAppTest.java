package org.wecancodeit.reviews.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringWebAppTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ReviewStorage reviewStorage;
    @MockBean
    private CategoryStorage categoryStorage;
    @MockBean
    private HashtagStorage hashtagStorage;

    @Test
    public void shouldReceiveOKFromReviewsEndpoint() throws Exception {
        mockMvc.perform(get("/reviews"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReceiveOKFromCategoriesEndpoint() throws Exception {
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReceiveOKFromHashtagsEndpoint() throws Exception {
        mockMvc.perform(get("/hashtags"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
