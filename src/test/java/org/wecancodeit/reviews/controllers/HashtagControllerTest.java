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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HashtagControllerTest {

    private HashtagsController underTest;
    private Model model;
    private HashtagStorage mockStorage;
    private Hashtag testHashtag;

    @BeforeEach
    void setUp() {
        mockStorage = mock(HashtagStorage.class);
        underTest = new HashtagsController(mockStorage);
        model = mock(Model.class);
        Category testCategory = new Category("Sick");
        Review testReview = new Review(testCategory, "Test", "test", 100);
        testHashtag = new Hashtag("#nice", testReview);
        when(mockStorage.findHashtagById(1L)).thenReturn(testHashtag);
    }

    @Test
    public void displayHashtagReturnsHashtagTemplate() {
        //TODO: Finish after single hashtag template is created
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
}
