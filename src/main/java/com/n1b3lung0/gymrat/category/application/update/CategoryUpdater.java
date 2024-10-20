package com.n1b3lung0.gymrat.category.application.update;

import com.n1b3lung0.gymrat.category.application.find.CategoryFinder;
import com.n1b3lung0.gymrat.category.domain.Category;
import com.n1b3lung0.gymrat.category.domain.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryUpdater {
    private final CategoryFinder finder;
    private final CategoryRepository repository;

    @Transactional
    public Category update(CategoryUpdateRequest request) {
        String name = request.getName();
        Category category = finder.findById(request.getId());
        if (StringUtils.isNotBlank(name) && !StringUtils.equals(name, category.getName())) {
            if (repository.findByNameAndActiveTrue(name).isPresent()) {
                throw new RuntimeException("Category with name " + name + " already exists");
            }
            category = category.withName(name);
        }
        category = repository.save(category);
        log.debug("Updated Category with name {}", category.getName());
        return category;
    }

}
