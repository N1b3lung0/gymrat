package com.n1b3lung0.gymrat.category.application.find;

import com.n1b3lung0.gymrat.category.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private String id;
    private String name;

    public static CategoryResponse fromCategory(Category category) {
        return category != null ? new CategoryResponse(
                String.valueOf(category.getId()),
                category.getName()
        ) : new CategoryResponse();
    }
}
