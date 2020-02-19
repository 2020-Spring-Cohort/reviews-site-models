package org.wecancodeit.reviews;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    private int price;
    private static int idCount = 1;
    private int reviewId;

    protected Review() {
    }

    public Review(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.reviewId = ++idCount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getReviewId() {
        return reviewId;
    }
}
