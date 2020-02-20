package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.repositories.HashtagRepository;

import java.util.Collection;

@Service
public class HashtagStorageJpaImpl implements HashtagStorage {

    HashtagRepository repository;

    public HashtagStorageJpaImpl(HashtagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Hashtag> getAll() {
        return (Collection<Hashtag>) repository.findAll();
    }

    @Override
    public void add(Hashtag hashtag) {

        repository.save(hashtag);

    }
}
