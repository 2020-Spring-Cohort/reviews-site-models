package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.CategoryRepository;
import org.wecancodeit.reviews.models.CategoryStorage;

import java.util.Collection;

@Service
public class CategoryStorageJpaImpl implements CategoryStorage {

    CategoryRepository repository;

    public CategoryStorageJpaImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Category> getAll() {
        return (Collection<Category>) repository.findAll();
    }

    @Override
    public void add(Category category) {
        repository.save(category);
    }
}
