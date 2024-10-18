package com.n1b3lung0.gymrat.category.domain;

import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findByName(String name);
}
