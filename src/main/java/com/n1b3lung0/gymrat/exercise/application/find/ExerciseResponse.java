package com.n1b3lung0.gymrat.exercise.application.find;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.Level;
import com.n1b3lung0.gymrat.exercise.domain.Muscle;
import com.n1b3lung0.gymrat.exercise.domain.Routine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExerciseResponse {

    private String id;

    private String name;

    private Level level;

    private Set<Routine> routines;

    private Muscle primaryMuscle;

    private Set<Muscle> secondaryMuscles;

    @EqualsAndHashCode.Exclude
    private ZonedDateTime createdAt;

    @EqualsAndHashCode.Exclude
    private String createdBy;

    @EqualsAndHashCode.Exclude
    private ZonedDateTime updatedAt;

    @EqualsAndHashCode.Exclude
    private String updatedBy;

    private Boolean active;

    @EqualsAndHashCode.Exclude
    private ZonedDateTime deletedAt;

    @EqualsAndHashCode.Exclude
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
