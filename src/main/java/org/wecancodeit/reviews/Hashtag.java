package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    public Hashtag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

