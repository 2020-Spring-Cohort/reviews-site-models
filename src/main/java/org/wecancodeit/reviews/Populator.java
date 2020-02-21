package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorage categoryStorage;
    private ReviewStorage reviewStorage;
    private HashtagStorage hashtagStorage;

    public Populator(CategoryStorage categoryStorage, ReviewStorage reviewStorage, HashtagStorage hashtagStorage) {
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @Override
    public void run(String... args) {
        Category cool = new Category("Cool");
        categoryStorage.store(cool);

        Review coolReview1 = new Review(cool, "Test", "Test", 123);
        Review coolReview2 = new Review(cool, "Test2", "Test", 321);
        Review coolReview3 = new Review(cool, "Test2", "Test", 789);
        reviewStorage.store(coolReview1);
        reviewStorage.store(coolReview2);
        reviewStorage.store(coolReview3);

        Hashtag nice = new Hashtag("#nice", coolReview3, coolReview1);
        hashtagStorage.add(nice);

    }
}
