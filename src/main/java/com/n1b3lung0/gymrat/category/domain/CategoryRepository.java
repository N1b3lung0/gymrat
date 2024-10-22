package com.n1b3lung0.gymrat.category.domain;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    Optional<Category> findByName(String name);
    Optional<Category> findById(UUID id);
    Category save(Category category);
}
