package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.models.CategoryStorage;

@Component
public class Populator implements CommandLineRunner {

    CategoryStorage categoryStorage;

    public Populator(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @Override
    public void run(String... args) throws Exception {

        categoryStorage.add(new Category("casual shoes"));
        categoryStorage.add(new Category("athletic shoes"));
        categoryStorage.add(new Category("work shoes"));
        categoryStorage.add(new Category("dress shoes"));



    }
}
