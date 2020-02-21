package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.storage.CategoryStorage;

@Controller
@RequestMapping("categories")
public class CategoriesController {

    CategoryStorage storage;

    public CategoriesController(CategoryStorage storage) {
        this.storage = storage;
    }

    @RequestMapping
    public String displayCategories(Model model) {
        model.addAttribute("categories", storage.getAll());
        return "categories";
    }

    @GetMapping("/{categoryName}")
    public String displaySingleCategory(@PathVariable String categoryName, Model model) {
        Category retrievedCategory = storage.findCategoryByName(categoryName);
        model.addAttribute("category", retrievedCategory);

        return "category";
    }
}

