package com.n1b3lung0.gymrat.series.domain;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
            RestTime restTime,
            String createdBy
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
                AuditFields.create(createdBy)
        );
    }

    public Series update(Series series, String updatedBy) {
        assert series != null;
        assert series.auditFields != null;
        AuditFields newAuditFields = series.auditFields.update(updatedBy);
        return series.withAuditFields(newAuditFields);
    }

    public Series delete(Series series, String deletedBy) {
        assert series != null;
        assert series.auditFields != null;
        AuditFields newAuditFields = series.auditFields.delete(deletedBy);
        return series.withAuditFields(newAuditFields);
    }
}
