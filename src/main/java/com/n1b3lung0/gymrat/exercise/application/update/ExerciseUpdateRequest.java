package com.n1b3lung0.gymrat.exercise.application.update;

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
public class ExerciseUpdateRequest {
    private String id;
    private String name;
    private Level level;
    private Set<Routine> routines;
    private Muscle primaryMuscle;
    private Set<Muscle> secondaryMuscles;
}
