package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.ReviewRepository;
import org.wecancodeit.reviews.models.ReviewStorage;

import java.util.Collection;

@Service
public class ReviewStorageJpaImpl implements ReviewStorage {

    ReviewRepository repository;

    public ReviewStorageJpaImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Review> getAll() {
        return (Collection<Review>) repository.findAll();
    }

    @Override
    public void add(Review newReview) {
        repository.save(newReview);
    }
}
