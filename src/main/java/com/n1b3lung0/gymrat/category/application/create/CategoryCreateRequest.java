package com.n1b3lung0.gymrat.category.application.create;

import com.n1b3lung0.gymrat.category.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateRequest {
    private String name;

    public Category toCategory(String name) {
        return Category.create(name, "n1b3lung0");
    }
}
