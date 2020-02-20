package org.wecancodeit.reviews.storage;

import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.storage.repositories.CategoryRepository;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStorageJpaImplTest {

    @Test
    public void shouldStoreCategory() {
        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        CategoryStorage storage = new CategoryStorageJpaImpl(categoryRepository);
        Category testCategory = new Category("good shoes");
        when(categoryRepository.findAll()).thenReturn(Collections.singletonList(testCategory));
        storage.store(testCategory);
        verify(categoryRepository).save(testCategory);
        assertThat(storage.getAll()).contains(testCategory);
    }

    @Test
    public void shouldRetrieveSingleReviewByName() {
        CategoryRepository mockRepo = mock(CategoryRepository.class);
        Category testCategory1 = new Category("good");
        Category testCategory2 = new Category("bad");
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockRepo);
        underTest.store(testCategory1);
        underTest.store(testCategory2);
        Optional<Category> testCategory1Optional = Optional.of(testCategory1);
        when(mockRepo.findByName("good")).thenReturn(testCategory1Optional);

        Optional<Category> testCategory2Optional = Optional.of(testCategory2);
        when(mockRepo.findByName("bad")).thenReturn(testCategory2Optional);

        Category retrievedCategory1 = underTest.findCategoryByName("good");
        Category retrievedCategory2 = underTest.findCategoryByName("bad");
        assertThat(retrievedCategory1).isEqualTo(testCategory1);
        assertThat(retrievedCategory2).isEqualTo(testCategory2);
    }
}
