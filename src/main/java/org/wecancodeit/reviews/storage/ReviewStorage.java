package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Review;

import java.util.Collection;

public interface ReviewStorage {

    Collection<Review> getAll();

    void store(Review newReview);

    Review findReviewById(long id);
}
