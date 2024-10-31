package com.n1b3lung0.gymrat.exercise_series.domain;

import java.util.Optional;
import java.util.UUID;

public interface ExerciseSeriesRepository {
    Optional<ExerciseSeries> findById(UUID id);
    ExerciseSeries save(ExerciseSeries series);
}
