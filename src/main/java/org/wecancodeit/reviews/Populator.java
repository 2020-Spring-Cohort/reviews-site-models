package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Component
public class Populator implements CommandLineRunner {

    CategoryStorage categoryStorage;

    ReviewStorage reviewStorage;

    public Populator(CategoryStorage categoryStorage, ReviewStorage reviewStorage) {
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
    }

    @Override
    public void run(String... args) throws Exception {

        Category casual_shoes = new Category("casual shoes");
        categoryStorage.add(casual_shoes);
        Category athletic_shoes = new Category("athletic shoes");
        categoryStorage.add(athletic_shoes);
        Category work_shoes = new Category("work shoes");
        categoryStorage.add(work_shoes);
        Category dress_shoes = new Category("dress shoes");
        categoryStorage.add(dress_shoes);

        reviewStorage.add(new Review(casual_shoes, "Casual shoes", "These are literally the worst shoes I've ever worn.", 100));
        reviewStorage.add(new Review(casual_shoes, "abc", "123", 50));
        reviewStorage.add(new Review(work_shoes, "abc", "123", 50));

    }
}
