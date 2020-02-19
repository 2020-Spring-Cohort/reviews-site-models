package org.wecancodeit.reviews.models;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.Review;

    public interface ReviewRepository extends CrudRepository<Review, Long> {


    }

