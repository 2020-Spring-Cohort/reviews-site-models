package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("hashtags")
public class HashtagsController {

    @RequestMapping(value = "")
    public String displayHashtags(Model model) {
        model.addAttribute("title", "hashtags");
        return "hashtags";
    }


}
