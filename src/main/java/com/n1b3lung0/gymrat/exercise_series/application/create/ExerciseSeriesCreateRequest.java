package com.n1b3lung0.gymrat.exercise_series.application.create;

import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import com.n1b3lung0.gymrat.workout.domain.Workout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseSeriesCreateRequest {

    private String workoutId;

    private String exerciseId;

    private Set<String> seriesIds;

    public ExerciseSeries toExerciseSeries(
            Workout workout,
            Exercise exercise
    ) {
        return ExerciseSeries.create(
                workout,
                exercise,
                "n1b3lung0"
        );
    }
}
