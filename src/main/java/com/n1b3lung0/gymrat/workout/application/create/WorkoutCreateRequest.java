package com.n1b3lung0.gymrat.workout.application.create;

import com.n1b3lung0.gymrat.workout.domain.Workout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutCreateRequest {

    private ZonedDateTime startWorkout;
    private ZonedDateTime endWorkout;

    public Workout toWorkout(
            ZonedDateTime startWorkout,
            ZonedDateTime endWorkout
    ) {
        return Workout.create(
                startWorkout,
                endWorkout
        );
    }
}
