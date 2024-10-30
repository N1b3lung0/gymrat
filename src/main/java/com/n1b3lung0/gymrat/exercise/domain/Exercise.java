package com.n1b3lung0.gymrat.exercise.domain;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.common.vo.File;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
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
    @Column(name = "description")
    String description;

    @With
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "image_name")),
            @AttributeOverride(name = "description", column = @Column(name = "image_description")),
            @AttributeOverride(name = "url", column = @Column(name = "image_url")),
    })
    File image;

    @With
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "video_name")),
            @AttributeOverride(name = "description", column = @Column(name = "video_description")),
            @AttributeOverride(name = "url", column = @Column(name = "video_url")),
    })
    File video;

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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "exercise")
    Set<ExerciseSeries> exerciseSeries;

    @With
    @Embedded
    AuditFields auditFields;

    public static Exercise create(
            String name,
            String description,
            File image,
            File video,
            Level level,
            Set<Routine> routines,
            Muscle primaryMuscle,
            Set<Muscle> secondaryMuscles,
            String createdBy
    ) {
        return new Exercise(
                null,
                name,
                description,
                image,
                video,
                level,
                routines,
                primaryMuscle,
                secondaryMuscles,
                new HashSet<>(),
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
