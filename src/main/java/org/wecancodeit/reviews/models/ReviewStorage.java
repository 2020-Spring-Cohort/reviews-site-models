package org.wecancodeit.reviews.models;

import org.wecancodeit.reviews.Review;

import java.util.Collection;

public interface ReviewStorage {

    Collection<Review> getAll();

    void add(Review newReview);

}
