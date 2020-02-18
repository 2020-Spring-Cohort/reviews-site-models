package org.wecancodeit.reviews;

public class Hashtag {


    private String name;
    private int id;

    // Needed for JPA
    protected Hashtag() {
    }

    public Hashtag(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

