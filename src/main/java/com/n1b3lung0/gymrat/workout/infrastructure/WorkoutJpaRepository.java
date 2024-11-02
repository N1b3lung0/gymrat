package com.n1b3lung0.gymrat.workout.infrastructure;

import com.n1b3lung0.gymrat.workout.domain.Workout;
import com.n1b3lung0.gymrat.workout.domain.WorkoutRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface WorkoutJpaRepository extends WorkoutRepository, JpaRepository<Workout, UUID>, JpaSpecificationExecutor<Workout> {
}
