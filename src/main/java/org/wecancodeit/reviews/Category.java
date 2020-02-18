package org.wecancodeit.reviews;

import java.util.Collection;

public class Category {

    private String name;
    private Collection<Review> reviews;

    public Category(String name, Collection<Review> reviews) {
        this.name = name;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}
