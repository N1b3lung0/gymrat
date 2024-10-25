package com.n1b3lung0.gymrat.exercise.application.update;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.exercise.domain.Level;
import com.n1b3lung0.gymrat.exercise.domain.Muscle;
import com.n1b3lung0.gymrat.exercise.domain.Routine;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseUpdateRequest {

    @NotBlank
    private String id;

    @NotBlank
    @Size(min = 4, max = 255, message = ExceptionConstants.EXERCISE_NAME_LENGTH_NOT_VALID)
    private String name;

    private Level level;

    private Set<Routine> routines;

    private Muscle primaryMuscle;

    private Set<Muscle> secondaryMuscles;
}
