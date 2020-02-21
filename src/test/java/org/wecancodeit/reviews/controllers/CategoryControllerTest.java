package org.wecancodeit.reviews.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.storage.CategoryStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoryControllerTest {

    private MockMvc mockMvc;
    private CategoriesController underTest;
    private CategoryStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoriesController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldReturnViewWithOneCategory() {
        Category testCategory = new Category("Good");
        when(mockStorage.findCategoryByName("Good")).thenReturn(testCategory);

        underTest.displaySingleCategory("Good", mockModel);

        verify(mockStorage).findCategoryByName("Good");
        verify(mockModel).addAttribute("category", testCategory);
    }

    @Test
    public void shouldReturnViewNamedCategoriesWhenDisplaySingleCategoryIsCalled() {
        String viewName = underTest.displaySingleCategory("Good", mockModel);
        assertThat(viewName).isEqualTo("categories");
    }

    @Test
    public void shouldGoToIndividualEndPoint() throws Exception {
        Category testCategory = new Category("Nice");
        when(mockStorage.findCategoryByName("Cool")).thenReturn(testCategory);

        mockMvc.perform(get("/categories/Cool"))
                .andExpect(status().isOk())
                .andExpect(view().name("categories"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("category", testCategory));
    }

//    @Test
//    public void categoriesEndPointShouldDisplayAllCategories() throws Exception {
//        Category testCategory = new Category("Test");
//
//        List<Category> categoryList = Collections.singletonList(testCategory);
//
//        when(mockStorage.getAll()).thenReturn(categoryList);
//
//        mockMvc.perform(get("/categories"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(view().name("categories"))
//                .andExpect(model().attributeExists("categories"))
//                .andExpect(model().attribute("categories", categoryList));
//    }
}
