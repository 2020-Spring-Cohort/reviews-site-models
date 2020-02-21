package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.HashtagStorage;


@Controller
@RequestMapping("hashtags")
public class HashtagsController {

    HashtagStorage storage;

    public HashtagsController(HashtagStorage storage) {
        this.storage = storage;
    }

    @GetMapping
    public String displayHashtags(Model model) {
        model.addAttribute("hashtags", storage.getAll());
        return "hashtags";
    }

    @GetMapping("/{hashTagId}")
    public String displayHashtag(@PathVariable long hashTagId, Model model) {
        Hashtag retrievedHashtag = storage.findHashtagById(hashTagId);
        model.addAttribute("hashtag", retrievedHashtag);
        return "hashtags";
    }
}
