package com.n1b3lung0.gymrat.exercise.application.find;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.Level;
import com.n1b3lung0.gymrat.exercise.domain.Muscle;
import com.n1b3lung0.gymrat.exercise.domain.Routine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseResponse {
    private String id;
    private String name;
    private Level level;
    private Set<Routine> routines;
    private Muscle primaryMuscle;
    private Set<Muscle> secondaryMuscles;
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
                exercise.getLevel(),
                exercise.getRoutines(),
                exercise.getPrimaryMuscle(),
                exercise.getSecondaryMuscles(),
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
