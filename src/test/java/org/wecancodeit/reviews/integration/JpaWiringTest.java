package org.wecancodeit.reviews.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.CategoryRepository;
import org.wecancodeit.reviews.storage.repositories.HashtagRepository;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext
public class JpaWiringTest {
    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private HashtagRepository hashtagRepo;


    @Test
    public void categoryShouldHaveAListOfReviews() {
        Category testCategory = new Category("shoes");
        Review testReview = new Review(testCategory, "review title", "description", 100);

        categoryRepo.save(testCategory);
        reviewRepo.save(testReview);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOptional = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOptional.get();
        Review retrievedReview = reviewRepo.findById(testReview.getId()).get();

        assertThat(retrievedCategory.getReviews()).contains(testReview);
    }

    @Test
    public void hashtagsShouldBeAbleToHaveMultipleReviews() {

        Category testCategory = new Category("shoes");
        Review testReview1 = new Review("Test", testCategory, "review title1", "description", 200);
        Review testReview2 = new Review("Test", testCategory, "review title2", "description", 50);
        Review testReview3 = new Review("Test", testCategory, "review title3", "description", 100);

        Hashtag testHashtag1 = new Hashtag("#cool", testReview1, testReview2);
        Hashtag testHashtag2 = new Hashtag("#awesome", testReview1, testReview3);

        categoryRepo.save(testCategory);

        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);
        reviewRepo.save(testReview3);

        hashtagRepo.save(testHashtag1);
        hashtagRepo.save(testHashtag2);

        testReview1.getHashtags().add(testHashtag1);
        testReview1.getHashtags().add(testHashtag2);
        testReview2.getHashtags().add(testHashtag1);
        testReview3.getHashtags().add(testHashtag2);

        entityManager.flush();
        entityManager.clear();

        Review retrievedReview = reviewRepo.findById(testReview1.getId()).get();
        Hashtag retrievedHashtag1 = hashtagRepo.findById(testHashtag1.getId()).get();
        Hashtag retrievedHashtag2 = hashtagRepo.findById(testHashtag2.getId()).get();
        assertThat(retrievedReview.getHashtags()).contains(testHashtag1, testHashtag2);
        assertThat(retrievedHashtag1.getReviews()).contains(testReview1, testReview2);
        assertThat(retrievedHashtag2.getReviews()).contains(testReview1, testReview3);
    }
}
