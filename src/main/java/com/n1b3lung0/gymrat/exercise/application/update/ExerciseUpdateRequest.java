package com.n1b3lung0.gymrat.exercise.application.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseUpdateRequest {
    private String id;
    private String name;
}
