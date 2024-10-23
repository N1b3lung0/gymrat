package com.n1b3lung0.gymrat.exercise.infrastructure;

import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExerciseJpaRepository extends ExerciseRepository, JpaRepository<Exercise, UUID> {
}
