package com.n1b3lung0.gymrat.series.domain;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.With;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "series")
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Series implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    UUID id;

    @With
    @Column(name = "serial_number")
    Integer serialNumber;

    @With
    @Column(name = "repetitions_to_do")
    Integer repetitionsToDo;

    @With
    @Column(name = "repetitions_done")
    Integer repetitionsDone;

    @With
    @Column(name = "intensity")
    Integer intensity;

    @With
    @Column(name = "weight")
    Float weight;

    @With
    @Column(name = "start_series")
    ZonedDateTime startSeries;

    @With
    @Column(name = "end_series")
    ZonedDateTime endSeries;

    @With
    @Column(name = "rest_time")
    @Enumerated(EnumType.STRING)
    RestTime restTime;

    @With
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "exercise_series_id", nullable = false)
    ExerciseSeries exerciseSeries;

    @With
    @Embedded
    AuditFields auditFields;

    public static Series create(
            Integer serialNumber,
            Integer repetitionsToDo,
            Integer repetitionsDone,
            Integer intensity,
            Float weight,
            ZonedDateTime startSeries,
            ZonedDateTime endSeries,
            RestTime restTime
    ) {
        return new Series(
                null,
                serialNumber,
                repetitionsToDo,
                repetitionsDone,
                intensity,
                weight,
                startSeries,
                endSeries,
                restTime,
                null,
                AuditFields.create("n1b3lung0")
        );
    }
}
