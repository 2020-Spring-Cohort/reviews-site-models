package org.wecancodeit.reviews.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.ReviewStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReviewControllerTest {

    private ReviewController underTest;
    private Model model;
    private ReviewStorage mockStorage;
    private Review testReview;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockStorage = mock(ReviewStorage.class);
        underTest = new ReviewController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        model = mock(Model.class);
        Category testCategory = new Category("Good");
        testReview = new Review(testCategory, "Test", "Test", 100);
        when(mockStorage.findReviewById(1L)).thenReturn(testReview);
    }

    @Test
    public void displayReviewReturnsReviewTemplate() {
        String result = underTest.displayReview(1L, model);
        assertThat(result).isEqualTo("review");
    }

    @Test
    public void displayReviewInteractsWithDependenciesCorrectly() {
        underTest.displayReview(1L, model);
        verify(mockStorage).findReviewById(1L);
        verify(model).addAttribute("review", testReview);
    }

    @Test
    public void displayReviewMappingIsCorrect() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/reviews/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("review"))
                .andExpect(model().attributeExists("review"))
                .andExpect(model().attribute("review", testReview));
    }

    @Test
    public void addReviewShouldRedirect() throws Exception {
        mockMvc.perform(post("/reviews/add")
                .param("reviewName", "Test")
                .param("reviewDescription", "Test")
                .param("reviewPrice", "100"))
                .andExpect(status().is3xxRedirection());
        verify(mockStorage).store(new Review("Test", "Test", 100));
    }
}
