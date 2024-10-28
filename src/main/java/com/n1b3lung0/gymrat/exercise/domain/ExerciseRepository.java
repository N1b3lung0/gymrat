package com.n1b3lung0.gymrat.exercise.domain;

import com.n1b3lung0.gymrat.common.criteria.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface ExerciseRepository {
    Page<Exercise> find(ExerciseSearchCriteria criteria);
    Optional<Exercise> findByName(String name);
    Optional<Exercise> findById(UUID id);
    Exercise save(Exercise exercise);
}
