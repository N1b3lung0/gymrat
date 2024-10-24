package com.n1b3lung0.gymrat.exercise.application.create;

import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.Level;
import com.n1b3lung0.gymrat.exercise.domain.Muscle;
import com.n1b3lung0.gymrat.exercise.domain.Routine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseCreateRequest {
    private String name;
    private Level level;
    private Set<Routine> routines;
    private Muscle primaryMuscle;
    private Set<Muscle> secondaryMuscles;

    public Exercise toExercise(
            String name,
            Level level,
            Set<Routine> routines,
            Muscle primaryMuscle,
            Set<Muscle> secondaryMuscles
    ) {
        return Exercise.create(
                name,
                level,
                routines,
                primaryMuscle,
                secondaryMuscles,
                "n1b3lung0"
        );
    }
}
