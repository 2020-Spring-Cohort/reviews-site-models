package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Hashtag {


    private String name;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Review> reviews;

    // Needed for JPA
    protected Hashtag() {
    }

    public Long getId() {
        return id;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public Hashtag(String name, Review... reviews) {
        this.name = name;
        this.reviews = Arrays.asList(reviews);
    }

    public Hashtag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashtag hashtag = (Hashtag) o;

        if (name != null ? !name.equals(hashtag.name) : hashtag.name != null) return false;
        return id != null ? id.equals(hashtag.id) : hashtag.id == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}

