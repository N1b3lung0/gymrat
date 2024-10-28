package com.n1b3lung0.gymrat.exercise.application.find;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.common.vo.File;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.Level;
import com.n1b3lung0.gymrat.exercise.domain.Muscle;
import com.n1b3lung0.gymrat.exercise.domain.Routine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExerciseResponse {

    private String id;

    private String name;

    private String description;

    private File image;

    private File video;

    private Level level;

    private Set<Routine> routines;

    private Muscle primaryMuscle;

    private Set<Muscle> secondaryMuscles;

    @EqualsAndHashCode.Exclude
    private AuditFields auditFields;

    public static ExerciseResponse fromExercise(Exercise exercise) {
        assert exercise != null;
        AuditFields auditFields = exercise.getAuditFields();
        assert auditFields != null;
        return new ExerciseResponse(
                String.valueOf(exercise.getId()),
                exercise.getName(),
                exercise.getDescription(),
                exercise.getImage(),
                exercise.getVideo(),
                exercise.getLevel(),
                exercise.getRoutines(),
                exercise.getPrimaryMuscle(),
                exercise.getSecondaryMuscles(),
                auditFields
        );
    }
}
