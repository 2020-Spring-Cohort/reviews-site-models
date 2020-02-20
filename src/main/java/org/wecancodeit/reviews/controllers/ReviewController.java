package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.ReviewStorage;


@Controller
@RequestMapping("reviews")
public class ReviewController {

    private ReviewStorage storage;

    public ReviewController(ReviewStorage storage) {
        this.storage = storage;
    }

    @GetMapping //root path
    public String displayReviews(Model model) {
        model.addAttribute("reviews", storage.getAll());
        return "reviews";
    }

    @GetMapping("add")
    public String addReviewForm(Model model) {
        model.addAttribute("title", "Add Review");
        return "add";
    }

    @PostMapping("add")
    public String processAddReviewForm(@RequestParam("reviewName") String reviewName, @RequestParam("reviewDescription") String reviewDescription, @RequestParam("reviewPrice") int reviewPrice) {
        storage.add(new Review(reviewName, reviewDescription, reviewPrice));
        return "redirect:";
    }
}





