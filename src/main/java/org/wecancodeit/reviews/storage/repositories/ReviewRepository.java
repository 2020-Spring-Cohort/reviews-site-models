package org.wecancodeit.reviews.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {


    }

