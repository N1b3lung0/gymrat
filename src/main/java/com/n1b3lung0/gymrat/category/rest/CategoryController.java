package com.n1b3lung0.gymrat.category.rest;

import com.n1b3lung0.gymrat.category.application.create.CategoryCreateRequest;
import com.n1b3lung0.gymrat.category.application.create.CategoryCreator;
import com.n1b3lung0.gymrat.category.application.delete.CategoryDeleter;
import com.n1b3lung0.gymrat.category.application.find.CategoryFinder;
import com.n1b3lung0.gymrat.category.application.find.CategoryResponse;
import com.n1b3lung0.gymrat.category.application.update.CategoryUpdateRequest;
import com.n1b3lung0.gymrat.category.application.update.CategoryUpdater;
import com.n1b3lung0.gymrat.category.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryFinder finder;
    private final CategoryCreator creator;
    private final CategoryUpdater updater;
    private final CategoryDeleter deleter;

    private static final String NAME_PATH = "/{name}";

    @GetMapping(value = NAME_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> findByName(@PathVariable String name) {
        return ResponseEntity.ok(CategoryResponse.fromCategory(finder.findByName(name)));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody CategoryCreateRequest request) {
        Category saved = creator.create(request);
        URI location = UriComponentsBuilder
                .fromPath("/categories/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> update(@RequestBody CategoryUpdateRequest request) {
        return ResponseEntity.ok(CategoryResponse.fromCategory(updater.update(request)));
    }

    @DeleteMapping(value = NAME_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable String name) {
        deleter.delete(name);
        return ResponseEntity.noContent().build();
    }
}
