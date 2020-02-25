package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;


@Controller
@RequestMapping("reviews")
public class ReviewController {

    private CategoryStorage categoryStorage;
    private ReviewStorage storage;
    private HashtagStorage hashtagStorage;

    public ReviewController(CategoryStorage categoryStorage, ReviewStorage storage, HashtagStorage hashtagStorage) {
        this.categoryStorage = categoryStorage;
        this.storage = storage;
        this.hashtagStorage = hashtagStorage;
    }

    @GetMapping //root path
    public String displayReviews(Model model) {
        model.addAttribute("reviews", storage.getAll());
        model.addAttribute("categories", categoryStorage.getAll());
        return "reviews";
    }


    @PostMapping("add")
    public String processAddReviewForm(@RequestParam("category") String category, @RequestParam("reviewName") String reviewName, @RequestParam("reviewDescription") String reviewDescription,
                                       @RequestParam("reviewPrice") int reviewPrice, @RequestParam(value = "userName", required = false) String userName) {

        Category retrievedCategory = categoryStorage.findCategoryByName(category);
        if (userName == null || userName.isEmpty()) {
            storage.store(new Review(retrievedCategory, reviewName, reviewDescription, reviewPrice));
        } else {
            storage.store(new Review(userName, retrievedCategory, reviewName, reviewDescription, reviewPrice));
        }
        return "redirect:";
    }

    @PostMapping("/{id}/set-hashtag")
    public String addHashtagToReview(@RequestParam("hashtagName") String hashtagName, @PathVariable long id) {
        Hashtag retrievedHashtag = hashtagStorage.findHashtagByName(hashtagName);
        Review retrievedReview = storage.findReviewById(id);
        retrievedReview.getHashtags().add(retrievedHashtag);
        storage.store(retrievedReview);
        return "redirect:/reviews/" + id;
    }

    @GetMapping("/{id}")
    public String displayReview(@PathVariable long id, Model model) {
        Review retrievedReview = storage.findReviewById(id);
        model.addAttribute("review", retrievedReview);
        model.addAttribute("hashtags", hashtagStorage.getAll());
        return "review";
    }
}





