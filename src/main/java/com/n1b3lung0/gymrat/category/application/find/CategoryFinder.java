package com.n1b3lung0.gymrat.category.application.find;

import com.n1b3lung0.gymrat.category.domain.Category;
import com.n1b3lung0.gymrat.category.domain.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryFinder {
    private final CategoryRepository repository;

    @Transactional(readOnly = true)
    public Category findByName(String name) {
        return repository.findByNameAndActiveTrue(name)
                .orElseThrow(() -> new RuntimeException("Category with name " + name + " not found"));
    }

    @Transactional(readOnly = true)
    public Category findById(String id) {
        return repository.findByIdAndActiveTrue(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));
    }
}
