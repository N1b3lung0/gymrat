package com.n1b3lung0.gymrat.category.infrastructure;

import com.n1b3lung0.gymrat.category.domain.Category;
import com.n1b3lung0.gymrat.category.domain.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryJpaRepository extends CategoryRepository, JpaRepository<Category, UUID> {
}
