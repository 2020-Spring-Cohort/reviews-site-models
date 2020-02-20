package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Hashtag;

import java.util.Collection;

public interface HashtagStorage {

    Collection<Hashtag> getAll();

    void add(Hashtag hashtag);

}
