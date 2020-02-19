package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.HashtagStorage;


@Controller
@RequestMapping("hashtags")
public class HashtagsController {

    HashtagStorage storage;

    @RequestMapping
    public String displayHashtags(Model model) {
        model.addAttribute("hashtags", storage.getAll());
        return "hashtags";
    }


}
