package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Category;

import java.util.Collection;

public interface CategoryStorage {

    Collection<Category> getAll();

    void store(Category category);

    Category findCategoryByName(String name);
}
