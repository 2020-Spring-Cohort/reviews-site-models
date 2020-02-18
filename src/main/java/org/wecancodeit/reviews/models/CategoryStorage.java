package org.wecancodeit.reviews.models;

import org.wecancodeit.reviews.Category;

import java.util.Collection;

public interface CategoryStorage {

    Collection<Category> getAll();

    void add(Category category);

}
