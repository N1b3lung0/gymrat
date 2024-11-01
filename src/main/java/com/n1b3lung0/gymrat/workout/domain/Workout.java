package com.n1b3lung0.gymrat.workout.domain;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.With;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "workouts")
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Workout implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    UUID id;

    @With
    @OneToMany(mappedBy = "workout")
    Set<ExerciseSeries> exerciseSeries;

    ZonedDateTime startWorkout;
    ZonedDateTime endWorkout;

    @With
    @Embedded
    AuditFields auditFields;
}
