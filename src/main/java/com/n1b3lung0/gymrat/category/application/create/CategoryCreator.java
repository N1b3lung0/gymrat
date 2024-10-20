package com.n1b3lung0.gymrat.category.application.create;

import com.n1b3lung0.gymrat.category.domain.Category;
import com.n1b3lung0.gymrat.category.domain.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryCreator {
    private final CategoryRepository repository;

    public Category create(CategoryCreateRequest request) {
        String name = request.getName();

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (repository.findByNameAndActiveTrue(name).isPresent()) {
            throw new IllegalArgumentException("Category with name " + name + " already exists");
        }

        Category category = request.toCategory(name);
        Category created = repository.save(category);
        log.debug("Created Category with name {} and id {}", name, created.getId());
        return created;
    }
}
