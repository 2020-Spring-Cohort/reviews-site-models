package org.wecancodeit.reviews;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String reviewTitle;
    private String userName;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    private String description;
    private int price;
    private static int idCount = 1;
    private int reviewId;

    public Review() {
    }

    public Review(String reviewTitle, String description, int price) {
        this.reviewTitle = reviewTitle;
        this.userName = "Anonymous";
        this.description = description;
        this.price = price;
        this.reviewId = idCount++;
    }

    public Review(String reviewTitle, String userName, String description, int price) {
        this.reviewTitle = reviewTitle;
        this.userName = userName;
        this.description = description;
        this.price = price;
        this.reviewId = idCount++;
    }

    public String getUserName() {
        return userName;
    }

    public String getReviewTitle() {
        return reviewTitle;
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
