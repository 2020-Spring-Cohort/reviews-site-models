package org.wecancodeit.reviews.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Lob
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
        this.hashtags = new ArrayList<>();
    }

    public Review(String reviewTitle, String userName, String description, int price) {
        this.reviewTitle = reviewTitle;
        this.userName = userName;
        this.description = description;
        this.price = price;
        this.reviewId = idCount++;
        this.hashtags = new ArrayList<>();
    }

    public Review(Category category, String title, String description, int price) {
        this.category = category;
        this.reviewTitle = title;
        this.description = description;
        this.price = price;
        this.hashtags = new ArrayList<>();
    }

    public Review(Category category, String reviewTitle, String description, int price, Hashtag... hashtags) {
        this.category = category;
        this.reviewTitle = reviewTitle;
        this.description = description;
        this.price = price;
        this.hashtags = new ArrayList<>(Arrays.asList(hashtags));
    }

    public Review(String userName, Category category, String reviewTitle, String description, int price) {
        this.userName = userName;
        this.category = category;
        this.reviewTitle = reviewTitle;
        this.description = description;
        this.price = price;
        this.hashtags = new ArrayList<>();
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public Long getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewTitle='" + reviewTitle + '\'' +
                ", userName='" + userName + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (price != review.price) return false;
        if (reviewTitle != null ? !reviewTitle.equals(review.reviewTitle) : review.reviewTitle != null) return false;
        if (userName != null ? !userName.equals(review.userName) : review.userName != null) return false;
        if (category != null ? !category.equals(review.category) : review.category != null) return false;
        return description != null ? description.equals(review.description) : review.description == null;
    }

    @Override
    public int hashCode() {
        int result = reviewTitle != null ? reviewTitle.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
