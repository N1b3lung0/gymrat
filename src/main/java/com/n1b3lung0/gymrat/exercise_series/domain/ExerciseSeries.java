package com.n1b3lung0.gymrat.exercise_series.domain;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.series.domain.Series;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "exercise_series")
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ExerciseSeries implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    UUID id;

    @With
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    Exercise exercise;

    @With
    @OneToMany(mappedBy = "exerciseSeries")
    Set<Series> series;

    @With
    @Embedded
    AuditFields auditFields;

    public static ExerciseSeries create(
            Exercise exercise,
            String createdBy
    ) {
        return new ExerciseSeries(
                null,
                exercise,
                new HashSet<>(),
                AuditFields.create(createdBy)
        );
    }

    public ExerciseSeries delete(ExerciseSeries exerciseSeries, String deletedBy) {
        assert exerciseSeries != null;
        assert exerciseSeries.auditFields != null;
        AuditFields newAuditFields = exerciseSeries.auditFields.delete(deletedBy);
        return exerciseSeries.withAuditFields(newAuditFields);
    }
}
