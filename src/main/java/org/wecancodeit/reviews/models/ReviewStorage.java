package org.wecancodeit.reviews.models;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.Review;

import java.util.ArrayList;

@Service
public class ReviewStorage {

    private ArrayList<Review> reviews = new ArrayList<>();

    public ArrayList<Review> getAll() {
        return reviews;
    }

    public void add(Review newReview) {
        reviews.add(newReview);
    }


    public Review getById(int id) {
        Review theReview = new Review();

        for (Review candidateReview : reviews) {
            if (candidateReview.getId() == id) {
                theReview = candidateReview;
            }
        }
        return theReview;

    }
}