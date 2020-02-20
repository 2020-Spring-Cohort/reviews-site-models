package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Collection<Review> reviews;

    protected Category() {
    }

    public Category(String name, Collection<Review> reviews) {
        this.name = name;
        this.reviews = reviews;
    }

    public Category(String typeOfShoe) {
        name = typeOfShoe;
    }

    public String getName() {
        return name;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}
