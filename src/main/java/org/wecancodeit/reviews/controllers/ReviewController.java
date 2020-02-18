package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.Review;
import org.wecancodeit.reviews.models.ReviewStorage;


@Controller
@RequestMapping("reviews")
public class ReviewController {

    private ReviewStorage reviews;

    public ReviewController(ReviewStorage reviews) {
        this.reviews = reviews;
    }

    @RequestMapping(value = "") //root path
    public String displayReviews(Model model) {

        model.addAttribute("reviews", reviews.getAll());
        model.addAttribute("title", "Shoe's Reviews");
        return "reviewView";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addReviewForm(Model model) {
        model.addAttribute("title", "Add Review");
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddReviewForm(@RequestParam("reviewName") String reviewName, @RequestParam("reviewDescription") String reviewDescription, Model model) {
        reviews.add(new Review(reviewName, reviewDescription));
        model.addAttribute("");
        return "redirect:";
    }
}





