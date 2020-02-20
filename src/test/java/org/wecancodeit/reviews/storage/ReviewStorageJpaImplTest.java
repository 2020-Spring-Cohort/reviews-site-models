package org.wecancodeit.reviews.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ReviewStorageJpaImplTest {

    private ReviewRepository reviewRepository;
    private ReviewStorage storage;
    private Review review;

    @BeforeEach
    void setUp() {
        reviewRepository = mock(ReviewRepository.class);
        storage = new ReviewStorageJpaImpl(reviewRepository);
        Category category = new Category("good shoes");
        review = new Review(category, "Test", "Test", 100);
    }

    @Test
    public void shouldFindReviewByID() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));
        Review retrievedReview = storage.findReviewById(1L);
        assertThat(retrievedReview).isEqualTo(review);
    }

    @Test
    public void shouldStoreReview() {
        storage.store(review);
        verify(reviewRepository).save(review);
    }

}
