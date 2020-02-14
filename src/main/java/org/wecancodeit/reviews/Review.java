package org.wecancodeit.reviews;

public class Review {

    private String name;
    private String description;
    private int price;
    private String color;
    private double size;

    public Review(String name, String description, int price, String color, double size) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.color = color;
        this.size = size;
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

    public String getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }
}
