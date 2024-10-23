package com.n1b3lung0.gymrat.exercise.application.find;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseResponse {
    private String id;
    private String name;
    private ZonedDateTime createdAt;
    private String createdBy;
    private ZonedDateTime updatedAt;
    private String updatedBy;
    private Boolean active;
    private ZonedDateTime deletedAt;
    private String deletedBy;

    public static ExerciseResponse fromExercise(Exercise exercise) {
        assert exercise != null;
        AuditFields auditFields = exercise.getAuditFields();
        assert auditFields != null;
        return new ExerciseResponse(
                String.valueOf(exercise.getId()),
                exercise.getName(),
                auditFields.getCreatedAt(),
                auditFields.getCreatedBy(),
                auditFields.getUpdatedAt(),
                auditFields.getUpdatedBy(),
                auditFields.getActive(),
                auditFields.getDeletedAt(),
                auditFields.getDeletedBy()
        );
    }
}
