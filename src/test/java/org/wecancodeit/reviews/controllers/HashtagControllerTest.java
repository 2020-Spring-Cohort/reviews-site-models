package org.wecancodeit.reviews.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.HashtagStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HashtagControllerTest {

    private HashtagsController underTest;
    private Model model;
    private HashtagStorage mockStorage;
    private Hashtag testHashtag;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockStorage = mock(HashtagStorage.class);
        underTest = new HashtagsController(mockStorage);
        model = mock(Model.class);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        Category testCategory = new Category("Sick");
        Review testReview = new Review(testCategory, "Test", "test", 100);
        testHashtag = new Hashtag("#nice", testReview);
        when(mockStorage.findHashtagById(1L)).thenReturn(testHashtag);
    }

    @Test
    public void displayHashtagReturnsHashtagTemplate() {
        String result = underTest.displayHashtag(1L, model);
        assertThat(result).isEqualTo("hashtag");
        verify(mockStorage).findHashtagById(1L);
    }

    @Test
    public void displayHashtagInteractsWithDependenciesCorrectly() {
        underTest.displayHashtag(1L, model);
        verify(mockStorage).findHashtagById(1L);
        verify(model).addAttribute("hashtag", testHashtag);
    }

    @Test
    public void displayHashtagMappingIsCorrect() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/hashtags/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("hashtag"))
                .andExpect(model().attributeExists("hashtag"))
                .andExpect(model().attribute("hashtag", testHashtag));
    }

    @Test
    public void addHashtagShouldRedirect() throws Exception {
        mockMvc.perform(post("/hashtags/add-hashtag").param("hashtag", "test"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        verify(mockStorage).add(new Hashtag("test"));
    }
}
