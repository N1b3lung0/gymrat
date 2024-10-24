package com.n1b3lung0.gymrat.exercise.domain;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.With;

import java.io.Serial;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "exercises")
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Exercise implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    UUID id;

    @With
    @Column(name = "name", nullable = false, unique = true)
    String name;

    @With
    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    Level level;

    @With
    @Column(name = "routine")
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "routines", joinColumns = @JoinColumn(name = "exercise_id"))
    Set<Routine> routines;

    @With
    @Column(name = "primary_muscle")
    @Enumerated(EnumType.STRING)
    Muscle primaryMuscle;

    @With
    @Column(name = "secondary_muscle")
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "secondary_muscles", joinColumns = @JoinColumn(name = "exercise_id"))
    Set<Muscle> secondaryMuscles;

    @With
    @Embedded
    AuditFields auditFields;

    public static Exercise create(
            String name,
            Level level,
            Set<Routine> routines,
            Muscle primaryMuscle,
            Set<Muscle> secondaryMuscles,
            String createdBy
    ) {
        return new Exercise(
                null,
                name,
                level,
                routines,
                primaryMuscle,
                secondaryMuscles,
                AuditFields.create(createdBy)
        );
    }

    public Exercise update(Exercise exercise, String updatedBy) {
        assert exercise != null;
        assert exercise.auditFields != null;
        AuditFields newAuditFields = exercise.auditFields.update(updatedBy);
        return exercise.withAuditFields(newAuditFields);
    }

    public Exercise delete(Exercise exercise, String deletedBy) {
        assert exercise != null;
        assert exercise.auditFields != null;
        AuditFields newAuditFields = exercise.auditFields.delete(deletedBy);
        return exercise.withAuditFields(newAuditFields);
    }
}
