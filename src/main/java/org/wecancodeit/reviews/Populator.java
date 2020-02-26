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
        Category casual = new Category("Casual Shoes");
        Category work = new Category("Work Boots");
        Category athletic = new Category("Athletic Shoes");
        categoryStorage.store(casual);
        categoryStorage.store(work);
        categoryStorage.store(athletic);

        Review casualReview = new Review(casual, "Terrible Shoes", "Terrible shoes. Do not recommend. Waste of money. I will sue the company.", 5);
        Review workReview = new Review("Noah D.", work, "Amazing Work Boots", "A steel-toed leather non-lacing mid-ankle slip-on work boot, they are waterproof, rugged and very comfortable to wear through a full day. They're worth every penny.", 150);
        Review athleticReview = new Review(athletic, "Incredible Shoes", "Lightweight, good ankle support, foam padding for comfort.", 200);
        reviewStorage.store(casualReview);
        reviewStorage.store(workReview);
        reviewStorage.store(athleticReview);

        Hashtag rugged = new Hashtag("#rugged", workReview);
        Hashtag comfortable = new Hashtag("#comfortable", workReview, athleticReview);
        Hashtag carbon = new Hashtag("#carbonfibertoe", workReview);

        Hashtag terrible = new Hashtag("#terrible", casualReview);
        Hashtag disappoint = new Hashtag("#disappointment", casualReview);

        Hashtag sick = new Hashtag("#sick", athleticReview);
        Hashtag fire = new Hashtag("#fire", athleticReview);
        Hashtag basketball = new Hashtag("#basketball", athleticReview);
        Hashtag ball = new Hashtag("#ballislife", athleticReview);

        hashtagStorage.add(rugged);
        hashtagStorage.add(comfortable);
        hashtagStorage.add(carbon);
        hashtagStorage.add(terrible);
        hashtagStorage.add(disappoint);
        hashtagStorage.add(sick);
        hashtagStorage.add(fire);
        hashtagStorage.add(basketball);
        hashtagStorage.add(ball);

        workReview.getHashtags().add(rugged);
        workReview.getHashtags().add(comfortable);
        workReview.getHashtags().add(carbon);

        athleticReview.getHashtags().add(comfortable);
        athleticReview.getHashtags().add(sick);
        athleticReview.getHashtags().add(fire);
        athleticReview.getHashtags().add(basketball);
        athleticReview.getHashtags().add(ball);

        casualReview.getHashtags().add(terrible);
        casualReview.getHashtags().add(disappoint);

        reviewStorage.store(casualReview);
        reviewStorage.store(workReview);
        reviewStorage.store(athleticReview);

    }
}
