package org.wecancodeit.reviews.models;

import hashtagpojo.Hashtag;

import java.util.Collection;

public interface HashtagStorage {

    Collection<Hashtag> getAll();

    void add(Hashtag hashtag);

}
