package org.wecancodeit.reviews.models;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.Review;

import java.util.Collection;

@Service
public interface ReviewStorage {

    Collection<Review> getAll();

    void add(Review newReview);

}
