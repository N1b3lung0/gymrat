package com.n1b3lung0.gymrat.exercise.domain;

import java.util.Optional;
import java.util.UUID;

public interface ExerciseRepository {
    Optional<Exercise> findByName(String name);
    Optional<Exercise> findById(UUID id);
    Exercise save(Exercise exercise);
}
