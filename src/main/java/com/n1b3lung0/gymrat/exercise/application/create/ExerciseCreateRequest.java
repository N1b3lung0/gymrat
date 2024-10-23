package com.n1b3lung0.gymrat.exercise.application.create;

import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseCreateRequest {
    private String name;

    public Exercise toExercise(String name) {
        return Exercise.create(name, "n1b3lung0");
    }
}
