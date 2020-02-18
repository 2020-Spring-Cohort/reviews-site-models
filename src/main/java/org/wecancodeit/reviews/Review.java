package org.wecancodeit.reviews;

public class Review {

    private String name;
    private String description;
    private int price;
    private static int idCount = 1;
    private int reviewId;

    public Review(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        idCount++;
        this.reviewId = idCount;
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
