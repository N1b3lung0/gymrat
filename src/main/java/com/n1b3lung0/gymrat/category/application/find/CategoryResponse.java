package com.n1b3lung0.gymrat.category.application.find;

import com.n1b3lung0.gymrat.category.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private String id;
    private String name;
    private ZonedDateTime createdAt;
    private String createdBy;
    private ZonedDateTime updatedAt;
    private String updatedBy;
    private Boolean active;
    private ZonedDateTime deletedAt;
    private String deletedBy;

    public static CategoryResponse fromCategory(Category category) {
        return category != null ? new CategoryResponse(
                String.valueOf(category.getId()),
                category.getName(),
                category.getAuditFields().getCreatedAt(),
                category.getAuditFields().getCreatedBy(),
                category.getAuditFields().getUpdatedAt(),
                category.getAuditFields().getUpdatedBy(),
                category.getAuditFields().getActive(),
                category.getAuditFields().getDeletedAt(),
                category.getAuditFields().getDeletedBy()
        ) : new CategoryResponse();
    }
}
