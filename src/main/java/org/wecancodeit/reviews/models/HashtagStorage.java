package org.wecancodeit.reviews.models;

import org.wecancodeit.reviews.Hashtag;

import java.util.Collection;

public interface HashtagStorage {

    Collection<Hashtag> getAll();

    void add(Hashtag hashtag);

}
