package com.n1b3lung0.gymrat.category.application.find;

import com.n1b3lung0.gymrat.category.domain.Category;
import com.n1b3lung0.gymrat.category.domain.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryFinder {

    private final CategoryRepository repository;

    public Category findByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Category with name " + name + " not found"));
    }
}
