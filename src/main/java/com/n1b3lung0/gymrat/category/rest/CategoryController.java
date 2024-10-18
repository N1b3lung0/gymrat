package com.n1b3lung0.gymrat.category.rest;

import com.n1b3lung0.gymrat.category.application.find.CategoryFinder;
import com.n1b3lung0.gymrat.category.application.find.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryFinder finder;

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> findByName(@PathVariable String name) {
        return ResponseEntity.ok(CategoryResponse.fromCategory(finder.findByName(name)));
    }
}
