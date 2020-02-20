package org.wecancodeit.reviews.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.HashtagRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HashtagStorageJpaImplTest {

    private HashtagRepository hashtagRepo;
    private HashtagStorage underTest;
    private Hashtag testHashtag;

    @BeforeEach
    void setUp() {
        hashtagRepo = mock(HashtagRepository.class);
        underTest = new HashtagStorageJpaImpl(hashtagRepo);
        Category testCategory = new Category("good");
        Review testReview = new Review(testCategory, "Test", "Test", 100);
        testHashtag = new Hashtag("#cool", testReview);
    }

    @Test
    public void shouldFindHashtagByName() {
        when(hashtagRepo.findByName("#cool")).thenReturn(Optional.of(testHashtag));
        Hashtag retrievedHashtag = underTest.findHashtagByName("#cool");
        assertThat(retrievedHashtag).isEqualTo(testHashtag);
    }

    @Test
    public void shouldFindHashtagById() {
        when(hashtagRepo.findById(1L)).thenReturn(Optional.of(testHashtag));
        Hashtag retrievedHashtag = underTest.findHashtagById(1L);
        assertThat(retrievedHashtag).isEqualTo(testHashtag);
    }

    @Test
    public void shouldStoreHashtag() {

    }

}
