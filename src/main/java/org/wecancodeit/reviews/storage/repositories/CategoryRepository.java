package org.wecancodeit.reviews.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Category;

import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, Long> {


    Optional<Category> findByName(String name);
}


