package com.n1b3lung0.gymrat.category.application.delete;

import com.n1b3lung0.gymrat.category.application.find.CategoryFinder;
import com.n1b3lung0.gymrat.category.domain.Category;
import com.n1b3lung0.gymrat.category.domain.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryDeleter {
    private final CategoryFinder finder;
    private final CategoryRepository repository;

    @Transactional
    public void delete(String name) {
        Category category = finder.findByName(name);
        Category deleted = category.delete(category, "n1b3lung0");
        repository.save(deleted);
        log.debug("Deleting category with name {}", name);
    }
}
