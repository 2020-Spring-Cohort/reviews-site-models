
package org.wecancodeit.reviews.models;

public class Review {

    private String name;
    private String description;
    private int reviewId;
    private static int nextId = 1;

    public Review(String name, String description) {
        this();
        this.name = name;
        this.description = description;

    }

    public Review() {
        reviewId = nextId;
        nextId++;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getReviewId() {
        return reviewId;
    }

}

