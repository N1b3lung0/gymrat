package com.n1b3lung0.gymrat.exercise_series.infrastructure;

import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeriesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ExerciseSeriesJpaRepository extends ExerciseSeriesRepository, JpaRepository<ExerciseSeries, UUID>, JpaSpecificationExecutor<ExerciseSeries> {
}
