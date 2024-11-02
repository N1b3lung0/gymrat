package com.n1b3lung0.gymrat.workout.domain;

import java.util.Optional;
import java.util.UUID;

public interface WorkoutRepository {
    Optional<Workout> findById(UUID id);
    Workout save(Workout workout);
}
