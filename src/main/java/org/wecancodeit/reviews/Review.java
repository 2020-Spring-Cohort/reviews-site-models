package org.wecancodeit.reviews;

public class Review {

    private String name;
    private String description;
    private int price;
    private int id;

    public Review() {
    }

    public Review(String name, String description, int price, int id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }

    public Review(String reviewName, String reviewDescription) {
        name = reviewName;
        description = reviewDescription;
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

    public int getId() {
        return id;
    }
}
